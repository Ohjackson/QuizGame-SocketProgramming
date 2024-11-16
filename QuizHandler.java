package Quiz;
import java.io.*;
import java.net.*;
class QuizHandler implements Runnable {
    private Socket socket;
    private QuizData quizData;
    private int score;

    QuizHandler(Socket socket, QuizData quizData) {
        this.socket = socket;
        this.quizData = quizData;
        this.score = 0;
    }

    @Override
    public void run() {
        try (BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
             BufferedWriter outToClient = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"))) {

            int questionNumber = 1;
            int totalQuestions = quizData.getQuestions().size();

            for (QuizQuestion question : quizData.getQuestions()) {
                displayQuestion(outToClient, question, questionNumber, totalQuestions);
                boolean validAnswer = processAnswer(inFromClient, outToClient, question);
                if (validAnswer) {
                    score++;
                }
                questionNumber++;
            }

            displayFinalScore(outToClient, totalQuestions);
            socket.close();
        } catch (IOException e) {
            System.out.println("클라이언트 처리 중 오류 발생: " + e.getMessage());
        }
    }

    private void displayQuestion(BufferedWriter outToClient, QuizQuestion question, int questionNumber, int totalQuestions) throws IOException {
        outToClient.write("===================================\n");
        outToClient.write("문제 " + questionNumber + " / " + totalQuestions + "\n");
        outToClient.write(question.question + "\n");
        for (String option : question.options) {
            outToClient.write(option + "\n");
        }
        outToClient.write("정답을 입력하세요 (1~5): \n");
        outToClient.flush();
    }

    private boolean processAnswer(BufferedReader inFromClient, BufferedWriter outToClient, QuizQuestion question) throws IOException {
        boolean validAnswer = false;
        while (!validAnswer) {
            String clientAnswer = inFromClient.readLine();
            try {
                int answer = Integer.parseInt(clientAnswer);
                validAnswer = true;
                if (question.isCorrectAnswer(answer)) {
                    outToClient.write("정답입니다!\n");
                    return true; // 정답일 경우 true 반환
                } else {
                    outToClient.write("틀렸습니다! 정답은 " + question.correctAnswer + " 입니다.\n");
                }
            } catch (NumberFormatException e) {
                outToClient.write("유효한 숫자를 입력하세요.\n"); // 유효하지 않은 입력 시 메시지 출력
            }
            outToClient.flush();
        }
        return false; // 틀린 답일 경우 false 반환
    }

    private void displayFinalScore(BufferedWriter outToClient, int totalQuestions) throws IOException {
        outToClient.write("===================================\n");
        int finalScore = (int) Math.round((score / (double) totalQuestions) * 100);
        outToClient.write("퀴즈를 마쳤습니다. 감사합니다!\n");
        outToClient.write("최종 점수: " + finalScore + " / 100\n");
        outToClient.flush();
    }
}
