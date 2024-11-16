package Quiz;

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 퀴즈 문제를 나타내는 클래스
 * 질문, 선택지, 정답 번호를 포함함
 */
class QuizQuestion {
    String question; // 퀴즈 질문
    String[] options; // 선택지 배열
    int correctAnswer; // 정답의 인덱스 (1부터 시작)

    /**
     * QuizQuestion 생성자
     * 
     * @param question 질문 텍스트
     * @param options 선택지 배열
     * @param correctAnswer 정답의 인덱스 (1부터 시작)
     */
    QuizQuestion(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    /**
     * 제공된 답이 정답인지 확인
     * 
     * @param answer 사용자가 입력한 답
     * @return 정답 여부 (true: 정답, false: 오답)
     */
    boolean isCorrectAnswer(int answer) {
        return answer == correctAnswer;
    }
}

/**
 * 퀴즈 게임 서버 클래스
 * 클라이언트와 연결을 관리하고 각 클라이언트를 스레드 풀로 처리
 */
public class TCPServerQuiz {
    private static final int PORT = 6789; // 서버 포트 번호
    private static final int THREAD_POOL_SIZE = 10; // 스레드 풀 크기

    public static void main(String[] args) {
        // 고정 크기의 스레드 풀 생성
        ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Quiz 서버 시작 (포트번호: " + PORT + ")");

            while (true) {
                // 클라이언트 연결 수락
                Socket clientSocket = serverSocket.accept();
                System.out.println("클라이언트 연결됨.");
                
                // 스레드 풀에 새로운 작업(퀴즈 처리) 제출
                threadPool.execute(new QuizHandler(clientSocket, new QuizData()));
            }
        } catch (IOException e) {
            // 서버 소켓 관련 오류 처리
            System.out.println("서버 오류 발생: " + e.getMessage());
        } finally {
            // 서버 종료 시 스레드 풀 종료
            threadPool.shutdown();
        }
    }
}
