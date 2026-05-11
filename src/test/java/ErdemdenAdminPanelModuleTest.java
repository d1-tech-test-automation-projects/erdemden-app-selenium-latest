import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ErdemdenAdminPanelModuleTest extends BaseStep {

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
    @DisplayName("Admin Paneli Sekmesine Git")
    public void NavigateToAdminPanel() {
        BaseStep.waitSeconds(3);
        LogTest.info("Admin Paneli sekmesi aranıyor...");
        WebElement adminPanelTab = BaseStep.findElementXpathWithWait("//*[@id='root']/div/nav/div[2]/div[2]/button[5]", TimeOut.SHORT.value);
        BaseStep.clickElement(adminPanelTab, "Admin Paneli sekmesine tıklandı");
        BaseStep.waitSeconds(2);
    }
}
