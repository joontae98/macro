package AutoRun;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class RobotDemo {
    public static void main(String[] args) {

        // 프로젝트의 진행 순서
        // 1. 프로그램 실행
        // 2. 마우스, 키보드 이벤트 실행
        // 3. 로그인 후 메일 확인

        Runtime rt = Runtime.getRuntime();
        String exeFile =  "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"; // 실행할 파일 위치
        Process p;

        int URLaddress[] = {

                KeyEvent.VK_N,
                KeyEvent.VK_A,
                KeyEvent.VK_V,
                KeyEvent.VK_E,
                KeyEvent.VK_R,
                KeyEvent.VK_PERIOD,
                KeyEvent.VK_C,
                KeyEvent.VK_O,
                KeyEvent.VK_M,
                KeyEvent.VK_ENTER


        };

        int ID[] = {
                KeyEvent.VK_K,
                KeyEvent.VK_J,
                KeyEvent.VK_O,
                KeyEvent.VK_O,
                KeyEvent.VK_N,
                KeyEvent.VK_T,
                KeyEvent.VK_A,
                KeyEvent.VK_E

        };

        int PW[] = {
                KeyEvent.VK_W,
                KeyEvent.VK_N,
                KeyEvent.VK_S,
                KeyEvent.VK_X,
                KeyEvent.VK_O,
                KeyEvent.VK_1,
                KeyEvent.VK_5,
                KeyEvent.VK_3,
                KeyEvent.VK_2,
                KeyEvent.VK_4

        };

        try {
            Robot robot = new Robot();
            p = rt.exec(exeFile); // 프로그램 실행
            p.waitFor();

            Thread.sleep(1000);

            robot.mouseMove(412, 53); //주소창에 마우스 가져가서 클릭
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

            for (int i = 0; i < URLaddress.length; i++) { // naver.com 입력 후 엔터까지
                robot.keyPress(URLaddress[i]);
                robot.keyRelease(URLaddress[i]);
            }

            robot.delay(1000); // 페이지 로딩을 위해 딜레이 1초

            robot.mouseMove(1144, 364); //naver.com 의 로그인 버튼
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

            robot.delay(1000); // 페이지 로딩을 위해 딜레이 1초

            robot.mouseMove(1005,392); //ID 텍스트상자에 마우스 가져가기
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

            for (int i = 0; i < ID.length; i++) { // ID 입력
                robot.keyPress(ID[i]);
                robot.keyRelease(ID[i]);
            }

            robot.mouseMove(1005,439); //PW 텍스트상자에 마우스 가져가기
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

            for (int i = 0; i < PW.length; i++) { // PW 입력
                robot.keyPress(PW[i]);
                robot.keyRelease(PW[i]);
            }

            robot.mouseMove(1005,538); //LOGIN 버튼 눌리기
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

            System.exit(0); // 시스템 종료

        } catch (AWTException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
