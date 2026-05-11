import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ErdemdenAboutUsModuleTest extends BaseStep {

    @BeforeAll
    public static void setup() {
        openChromeDriver();
    }

    @AfterAll
    public static void tearDownAll() {
        BaseStep.driverQuit();
    }

    @Test
    @Order(1)
    @DisplayName("Tarayıcıyı Aç ve Giriş Yap")
    public void OpenDriverAndLogin() {
        LogTest.info("Kullanıcı adı Input aranıyor");
        WebElement usernameInput = BaseStep.findElementXpathWithWait("//*[@id='email-address']", TimeOut.SHORT.value);
        BaseStep.clearAndType(usernameInput, "admin@erdemden.com", "Kullanıcı Adı");
        LogTest.info("Kullanıcı adı gönderildi");
        WebElement passwordInput = BaseStep.findElementXpathWithWait("//*[@id='password']", TimeOut.SHORT.value);
        LogTest.info("Parola Inputu bulunuyor");
        BaseStep.clearAndType(passwordInput, "Admin123!", "Şifre");
        LogTest.info("Parola gönderildi");
        LogTest.info("Giriş Yap butonu bulunuyor");
        WebElement loginClickButton = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/form/div[2]/button", TimeOut.SHORT.value);
        BaseStep.clickElement(loginClickButton, "Giriş yap butonuna tıklandı");
    }

    @Test
    @Order(2)
    @DisplayName("Hakkımızda Sekmesine Git")
    public void NavigateToAboutUs() {
        BaseStep.waitSeconds(3);
        LogTest.info("Hakkımızda sekmesi aranıyor...");
        WebElement aboutUsTab = BaseStep.findElementXpathWithWait("//*[@id='root']/div/nav/div[2]/div[2]/button[4]", TimeOut.SHORT.value);
        BaseStep.clickElement(aboutUsTab, "Hakkımızda sekmesine tıklandı");
        BaseStep.waitSeconds(2);
    }
}
