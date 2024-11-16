package Quiz;

import java.io.*;
import java.net.*;
import java.util.Properties;

public class TCPClientQuiz {
    public static void main(String[] args) {
        String serverIP = "localhost"; // 기본값 설정
        int port = 1234; // 기본값 설정

        // server_info.dat 파일에서 서버 정보 읽기
        try (FileInputStream fileInput = new FileInputStream("server_info.dat")) {
            Properties properties = new Properties();
            properties.load(fileInput);

            // 서버 IP와 포트 읽기
            serverIP = properties.getProperty("IP", serverIP); // 기본값 사용
            port = Integer.parseInt(properties.getProperty("PORT", String.valueOf(port))); // 기본값 사용
        } catch (FileNotFoundException e) {
            System.out.println("서버 정보 파일을 찾을 수 없습니다. 기본값(" + serverIP + ":" + port + ")으로 연결합니다.");
        } catch (IOException e) {
            System.out.println("서버 정보 파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
            return; // 서버 정보를 읽지 못하면 프로그램 종료
        }

        // 서버에 연결 시도
        try (Socket clientSocket = new Socket(serverIP, port)) {
            System.out.println("서버에 연결되었습니다. (" + serverIP + ":" + port + ")");

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), "UTF-8"));
            BufferedWriter outToServer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream(), "UTF-8"));
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

            String serverMessage;
            while ((serverMessage = inFromServer.readLine()) != null) {
                // 서버 메시지 출력
                System.out.println(serverMessage);

                // "정답을 입력하세요" 메시지가 나오면 사용자 입력 요청
                if (serverMessage.contains("정답을 입력하세요")) {
                    String userAnswer;
                    boolean validInput = false;
                    while (!validInput) { // 유효한 입력을 받을 때까지 반복
                        userAnswer = inFromUser.readLine();
                        try {
                            Integer.parseInt(userAnswer); // 숫자인지 확인
                            validInput = true;
                            outToServer.write(userAnswer + "\n"); // 유효한 숫자일 때만 서버에 전송
                            outToServer.flush();
                        } catch (NumberFormatException e) {
                            System.out.println("유효한 숫자를 입력하세요."); // 숫자가 아니면 에러 메시지 출력
                        }
                    }
                }
            }
            System.out.println("퀴즈가 종료되었습니다.");

        } catch (IOException e) {
            System.out.println("서버와 연결 중 오류 발생: " + e.getMessage());
        }
    }
}


//보고서 작성: 프로토콜 형식 설명, 아키텍처 다이어그램, 주요 로직에 대한 설명을 포함한 보고서를 준비할 것.