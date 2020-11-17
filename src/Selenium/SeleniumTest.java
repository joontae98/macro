package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) {

        // 프로젝트의 진행 순서
        // 1. selenium 라이브러리 다운 *크롬버전과 크롬드라이브버전 확인
        // 2. html 태그의 id 확인후 findElement 메서드를 이용하여 실행
        // 3. 로그인 후 메일 갯수 가져와서 출력
        SeleniumTest selTest = new SeleniumTest();
        selTest.crawl();

    }


    private WebDriver driver;

    private WebElement webElement;

    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "D:\\workspace\\IdeaProjects\\라이브러리\\selenium\\chromedriver.exe";

    private String base_url;

    public SeleniumTest() {
        super();

        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        driver = new ChromeDriver();

        base_url = "https://www.daum.net/";

    }

    public void crawl() {

        try {
            driver.get(base_url);

            webElement = driver.findElement(By.className("link_login"));
            webElement.click();
            Thread.sleep(1000);

            webElement = driver.findElement(By.id("id"));
            String website_id = ""; //id 입력
            webElement.sendKeys(website_id);
            Thread.sleep(1000);

            webElement = driver.findElement(By.id("inputPwd"));
            String website_pw = ""; //password 입력
            webElement.sendKeys(website_pw);
            Thread.sleep(1000);

            webElement = driver.findElement(By.id("loginBtn"));
            webElement.submit();
            Thread.sleep(1000);

            //메일 갯수를 가져오기 위한 경로 = xpath
            webElement = driver.findElement(By.xpath("//*[@id=\"mArticle\"]/div[1]/div[2]/ul/li[1]/em/a"));
            String mailCnt = webElement.getText();

            System.out.println("메일의 갯수 : " + mailCnt);


        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            driver.close();
        }

    }

}


