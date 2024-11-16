package Quiz;
import java.util.List;
import java.util.ArrayList;


class QuizData {
    private List<QuizQuestion> questions;

    QuizData() {
        questions = new ArrayList<>();
        
        questions.add(new QuizQuestion(
            "OSI 7 계층 모델의 순서는?",
            new String[]{
                "① 물리, 데이터 링크, 네트워크, 전송, 세션, 표현, 응용",
                "② 응용, 표현, 세션, 전송, 네트워크, 데이터 링크, 물리",
                "③ 응용, 전송, 인터넷, 네트워크 접근",
                "④ 세션, 표현, 물리, 응용, 데이터 링크, 네트워크, 전송",
                "⑤ 네트워크 접근, 응용, 전송, 인터넷"
            },
            2
        ));

        questions.add(new QuizQuestion(
            "TCP/IP 모델의 4 계층은?",
            new String[]{
                "① 응용, 표현, 세션, 전송",
                "② 물리, 데이터 링크, 네트워크, 응용",
                "③ 응용, 전송, 인터넷, 네트워크 접근",
                "④ 전송, 세션, 네트워크, 데이터 링크",
                "⑤ 네트워크 접근, 표현, 세션, 인터넷"
            },
            3
        ));

        questions.add(new QuizQuestion(
            "TCP와 UDP의 차이점?",
            new String[]{
                "① 연결 지향(TCP), 비연결(UDP)",
                "② 비연결 지향(TCP), 연결(UDP)",
                "③ TCP는 빠름, UDP는 느림",
                "④ TCP와 UDP는 동일",
                "⑤ TCP는 보안이 없음"
            },
            1
        ));

        questions.add(new QuizQuestion(
            "HTTP와 HTTPS의 차이?",
            new String[]{
                "① 포트 번호",
                "② 보안",
                "③ 빠른 속도",
                "④ 데이터 링크 레이어",
                "⑤ 데이터 압축"
            },
            2
        ));

        questions.add(new QuizQuestion(
            "IP 주소 구성 요소?",
            new String[]{
                "① MAC 주소와 서브넷",
                "② 게이트웨이와 호스트",
                "③ 네트워크와 호스트",
                "④ 브로드캐스트와 멀티캐스트",
                "⑤ 전송과 표현"
            },
            3
        ));

        questions.add(new QuizQuestion(
            "IPv4와 IPv6의 차이점?",
            new String[]{
                "① 16비트와 64비트",
                "② 32비트와 128비트",
                "③ 8비트와 64비트",
                "④ 128비트와 256비트",
                "⑤ 동일한 비트"
            },
            2
        ));

        questions.add(new QuizQuestion(
            "Subnetting의 목적?",
            new String[]{
                "① 속도 향상",
                "② 네트워크 분할과 보안",
                "③ 서버 유지보수",
                "④ 데이터 백업",
                "⑤ 실시간 전송"
            },
            2
        ));

        questions.add(new QuizQuestion(
            "라우터와 스위치의 차이?",
            new String[]{
                "① 같은 네트워크와 다른 네트워크",
                "② 하드웨어와 소프트웨어",
                "③ 동적 라우팅과 정적 라우팅",
                "④ 같은 데이터 링크와 물리 레이어",
                "⑤ 데이터 전송 속도"
            },
            1
        ));

        questions.add(new QuizQuestion(
            "MAC 주소와 IP 주소 차이?",
            new String[]{
                "① 논리적 vs 물리적",
                "② 물리적 vs 논리적",
                "③ 네트워크 위치와 전송 속도",
                "④ 게이트웨이와 서브넷",
                "⑤ 응용 계층과 데이터 링크 계층"
            },
            2
        ));

        questions.add(new QuizQuestion(
            "DNS의 역할?",
            new String[]{
                "① 도메인 이름 변환",
                "② 트래픽 관리",
                "③ 데이터 보안",
                "④ 네트워크 속도 향상",
                "⑤ 네트워크 충돌 방지"
            },
            1
        ));

        questions.add(new QuizQuestion(
            "DHCP의 역할?",
            new String[]{
                "① 데이터 암호화",
                "② 라우팅 관리",
                "③ IP 할당",
                "④ VPN 설정",
                "⑤ 서브넷 분할"
            },
            3
        ));

        questions.add(new QuizQuestion(
            "방화벽의 기능?",
            new String[]{
                "① 속도 향상",
                "② 데이터 백업",
                "③ 네트워크 보안",
                "④ 응용 프로그램 관리",
                "⑤ IP 변환"
            },
            3
        ));

        questions.add(new QuizQuestion(
            "VPN의 목적?",
            new String[]{
                "① 네트워크 연결 속도 향상",
                "② 외부 서버 접근 차단",
                "③ 안전한 연결",
                "④ 데이터 압축",
                "⑤ 네트워크 관리"
            },
            3
        ));

        questions.add(new QuizQuestion(
            "IP 주소 클래스 A의 범위?",
            new String[]{
                "① 128.0.0.0 - 191.255.255.255",
                "② 192.0.0.0 - 223.255.255.255",
                "③ 10.0.0.0 - 10.255.255.255",
                "④ 1.0.0.0 - 126.0.0.0",
                "⑤ 224.0.0.0 - 239.255.255.255"
            },
            4
        ));

        questions.add(new QuizQuestion(
            "Ping의 목적?",
            new String[]{
                "① 데이터 암호화",
                "② 네트워크 연결 확인",
                "③ 트래픽 관리",
                "④ 데이터 압축",
                "⑤ 라우팅 설정"
            },
            2
        ));
    }

    List<QuizQuestion> getQuestions() {
        return questions;
    }
}
