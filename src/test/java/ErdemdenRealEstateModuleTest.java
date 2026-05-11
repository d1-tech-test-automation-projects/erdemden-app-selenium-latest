import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ErdemdenRealEstateModuleTest extends BaseStep {

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
        WebElement loginClickButton = BaseStep.findElementXpathWithWait(
                "//*[@id='root']/div/main/div/div[2]/form/div[2]/button", TimeOut.SHORT.value);
        BaseStep.clickElement(loginClickButton, "Giriş yap butonuna tıklandı");
        BaseStep.waitSeconds(2);
    }

    @Test
    @Order(2)
    @DisplayName("Emlak Sekmesine Git")
    public void NavigateToRealEstate() {
        LogTest.info("Emlak sekmesi aranıyor...");
        WebElement realEstateTab = BaseStep.findElementXpathWithWait("//*[@id='root']/div/nav/div[2]/div[2]/button[2]",
                TimeOut.SHORT.value);
        BaseStep.clickElement(realEstateTab, "Emlak sekmesine tıklandı");
        BaseStep.waitSeconds(1);

        LogTest.info("Sayfa aşağı kaydırılıyor...");
        ((org.openqa.selenium.JavascriptExecutor) BaseStep.driver).executeScript("window.scrollBy(0, 400)");
        BaseStep.waitSeconds(2);
    }

    @Test
    @Order(3)
    @DisplayName("Konut Kategorisine Tıkla")
    public void selectResidentialOnly() {
        LogTest.info("Konut kategorisi seçiliyor...");
        WebElement residentialButton = BaseStep.findElementXpathWithWait("//button[text()='Konut']",
                TimeOut.SHORT.value);
        BaseStep.clickElement(residentialButton, "Konut butonu");
        BaseStep.waitSeconds(2);
        LogTest.info("Konut kategorisi seçimi tamamlandı.");

    }

    @Test
    @Order(4)
    @DisplayName("İş Yeri Kategorisine Tıkla")
    public void selectCommercialOnly() {
        LogTest.info("İş Yeri kategorisi seçiliyor...");
        WebElement commercialButton = BaseStep.findElementXpathWithWait("//button[text()='İş Yeri']",
                TimeOut.SHORT.value);
        BaseStep.clickElement(commercialButton, "İş Yeri butonu");
        BaseStep.waitSeconds(2);
        LogTest.info("İş Yeri kategorisi başarıyla seçildi.");
    }

    @Test
    @Order(5)
    @DisplayName("Arsa Kategorisine Tıkla")
    public void selectLandOnly() {
        LogTest.info("Arsa kategorisi seçiliyor...");
        WebElement landButton = BaseStep.findElementXpathWithWait("//button[text()='Arsa']", TimeOut.SHORT.value);
        BaseStep.clickElement(landButton, "Arsa butonu");
        BaseStep.waitSeconds(2);
        LogTest.info("Arsa kategorisi başarıyla seçildi.");
    }

    @Test
    @Order(6)
    @DisplayName("Emlak Kategorisi Seçimi: Tümü")
    public void selectAllRealEstate() {
        LogTest.info("Emlak kategorisi alanından seçim yapılıyor...");
        String allButtonXpath = "//button[text()='Tümü']";
        WebElement allButton = BaseStep.findElementXpathWithWait(allButtonXpath, TimeOut.SHORT.value);
        BaseStep.clickElement(allButton, "Tümü Kategorisi Seçim İşlemi");
        BaseStep.waitSeconds(2);
        LogTest.info("Tümü başarıyla seçildi.");
    }

    @Test
    @Order(7)
    @DisplayName("Emlak Durumu Seçimi: Satılık")
    public void selectSaleStatus() {
        LogTest.info("Emlak durumu alanından seçim yapılıyor...");
        String statusSelectXpath = "//select[option[@value='sale']]";
        WebElement statusDropdown = BaseStep.findElementXpathWithWait(statusSelectXpath, TimeOut.SHORT.value);
        BaseStep.selectElementFromDropdown(statusDropdown, "Satılık", "Emlak Durumu Seçim İşlemi");
        BaseStep.waitSeconds(2);
        LogTest.info("Satılık başarıyla seçildi.");
    }

    @Test
    @Order(8)
    @DisplayName("Emlak Durumu Sıfırlama: Tümü")
    public void resetRealEstateStatus() {
        LogTest.info("Emlak durumu alanından seçim yapılıyor...");
        String statusSelectXpath = "//select[option[@value='all']]";
        WebElement statusDropdown = BaseStep.findElementXpathWithWait(statusSelectXpath, TimeOut.SHORT.value);
        BaseStep.selectElementFromDropdown(statusDropdown, "Tümü", "Emlak Durumu Sıfırlama İşlemi");
        BaseStep.waitSeconds(2);
        LogTest.info("Tümü başarıyla seçildi.");
    }

    @Test
    @Order(9)
    @DisplayName("Fiyat Filtresi: Düşükten Yükseğe")
    public void selectPriceLowToHigh() {
        LogTest.info("Fiyat filtresi alanından seçim yapılıyor...");
        String priceFilterSelectXpath = "//select[option[@value='price_asc']]";
        WebElement priceDropdown = BaseStep.findElementXpathWithWait(priceFilterSelectXpath, TimeOut.SHORT.value);
        BaseStep.selectElementFromDropdown(priceDropdown, "Fiyat: Düşükten Yükseğe", "Fiyat Filtresi Seçim İşlemi");
        BaseStep.waitSeconds(2);
        LogTest.info("Fiyat: Düşükten Yükseğe başarıyla seçildi.");
    }

    @Test
    @Order(10)
    @DisplayName("Emlak Arama ve Silme")
    public void enterAndClearVilla() {
        LogTest.info("Emlak arama alanına veri girişi yapılıyor...");
        String searchFieldXpath = "//*[@id=\'root\']/div/main/div/div/div[2]/div[2]/div[2]/div/div[2]/div/input";
        WebElement searchInput = BaseStep.findElementXpathWithWait(searchFieldXpath, TimeOut.SHORT.value);
        BaseStep.clearAndType(searchInput, "VİLLA", "Emlak Arama Giriş İşlemi");
        BaseStep.waitSeconds(2);
        LogTest.info("Yazılan metin siliniyor...");
        BaseStep.clearAndType(searchInput, "", "Emlak Arama Giriş Silme İşlemi");
        LogTest.info("VİLLA başarıyla silindi.");
        BaseStep.waitSeconds(2);
    }


    @Test
    @Order(11)
    @DisplayName("Yeni Emlak İlanı Ekleniyor")
    public void addNewRealEstateAd() {
        LogTest.info("Yeni Emlak İlanı ekleme işlemi başlatılıyor...");

        WebElement addAdButton = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div/div[2]/div[1]/div", TimeOut.SHORT.value);
        BaseStep.clickElement(addAdButton, "İlan Ekle Butonu");
        BaseStep.waitSeconds(1);

        WebElement titleInput = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[1]/div[1]/input", TimeOut.SHORT.value);
        BaseStep.clearAndType(titleInput, "Sahibinden Satılık Villa", "İlan Başlığı");

        WebElement priceInput = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[1]/div[2]/input", TimeOut.SHORT.value);
        BaseStep.clearAndType(priceInput, "15000000", "Fiyat");

        WebElement dateInput = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[1]/div[3]/input", TimeOut.SHORT.value);
        BaseStep.clearAndType(dateInput, "08.05.2026", "İlan Tarihi");

        WebElement descriptionInput = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[1]/div[4]/textarea", TimeOut.SHORT.value);
        BaseStep.clearAndType(descriptionInput, "Harika konumda, geniş bahçeli lüks villa.", "Açıklama");

        WebElement cityDropdown = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[2]/div[1]/select", TimeOut.SHORT.value);
        BaseStep.selectElementFromDropdown(cityDropdown, "İstanbul", "İl Seçimi");
        BaseStep.waitSeconds(1);

        WebElement districtDropdown = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[2]/div[2]/select", TimeOut.SHORT.value);
        BaseStep.selectElementFromDropdown(districtDropdown, "Beşiktaş", "İlçe Seçimi");
        BaseStep.waitSeconds(1);

        WebElement neighborhoodDropdown = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[2]/div[3]/select", TimeOut.SHORT.value);
        BaseStep.selectElementFromDropdown(neighborhoodDropdown, "Bebek", "Mahalle Seçimi");

        WebElement streetInput = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[2]/div[4]/input", TimeOut.SHORT.value);
        BaseStep.clearAndType(streetInput, "Cevdet Paşa Cad. No:123", "Sokak/Cadde");

        WebElement typeSatilikRadio = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[3]/div[1]/div/label[2]/input", TimeOut.SHORT.value);
        BaseStep.clickElement(typeSatilikRadio, "İlan Türü: Kiralık");

        WebElement typeSatilikRadio2 = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[3]/div[1]/div/label[1]/input", TimeOut.SHORT.value);
        BaseStep.clickElement(typeSatilikRadio2, "İlan Türü: Satılık");
        
        WebElement categoryKonutBtn = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[3]/div[2]/div/button[1]", TimeOut.SHORT.value);
        BaseStep.clickElement(categoryKonutBtn, "Emlak Kategorisi: Konut");

        WebElement estateTypeDropdown = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[3]/div[3]/select", TimeOut.SHORT.value);
        BaseStep.selectElementFromDropdown(estateTypeDropdown, "Villa", "Emlak Türü");
        
        WebElement roomCountInput = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[3]/div[4]/input", TimeOut.SHORT.value);
        BaseStep.clearAndType(roomCountInput, "5+2", "Oda Sayısı");

        WebElement m2Input = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[3]/div[5]/input", TimeOut.SHORT.value);
        BaseStep.clearAndType(m2Input, "450", "Metrekare");

        WebElement totalFloorsInput = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[3]/div[6]/input", TimeOut.SHORT.value);
        BaseStep.clearAndType(totalFloorsInput, "3", "Toplam Kat");

        WebElement buildingAgeInput = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[3]/div[7]/input", TimeOut.SHORT.value);
        BaseStep.clearAndType(buildingAgeInput, "0", "Bina Yaşı");

        WebElement photoUpload = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[4]/div/button", TimeOut.SHORT.value);
        BaseStep.uploadFileViaDialog(photoUpload, "ev1.jpg", "İlan Fotoğrafı");

        WebElement submitButton = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[5]/button", TimeOut.SHORT.value);
        BaseStep.clickElement(submitButton, "İlanı Yayınla");

        LogTest.info("Yeni ilan başarıyla eklendi.");
        BaseStep.waitSeconds(3);
    }

    @Test
    @Order(12)
    @DisplayName("İlanı Aranıyor ve Düzenleniyor")
    public void searchAndEditAd() {
        LogTest.info("İlan arama ve düzenleme işlemi başlatılıyor...");

        WebElement searchInput = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div/div[2]/div[2]/div[2]/div/div[2]/div/input", TimeOut.SHORT.value);
        BaseStep.clearAndType(searchInput, "Sahibinden Satılık Villa", "İlan Arama");
        BaseStep.waitSeconds(2);

        WebElement adResultItem = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div/div[2]/div[2]/div[3]/div", TimeOut.SHORT.value);
        BaseStep.clickElement(adResultItem, "Arama Sonucu: İlan");
        BaseStep.waitSeconds(2); 

        WebElement editButton = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div/div[2]/div/div[2]/div[1]/div[4]/button[1]", TimeOut.SHORT.value);
        BaseStep.clickElement(editButton, "Düzenle Butonu");
        BaseStep.waitSeconds(1);

        WebElement priceInput = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div/div/form/div[1]/div[2]/input", TimeOut.SHORT.value);
        BaseStep.clearAndType(priceInput, "16000000", "Güncel Fiyat");

        WebElement descriptionInput = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div/div/form/div[1]/div[4]/textarea", TimeOut.SHORT.value);
        BaseStep.clearAndType(descriptionInput, "Harika konumda, geniş bahçeli ultra lüks villa.", "Güncel Açıklama");

        WebElement saveButton = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div/div/form/div[5]/button", TimeOut.SHORT.value);
        BaseStep.clickElement(saveButton, "Değişiklikleri Kaydet Butonu");

        LogTest.info("İlan başarıyla düzenlendi.");
        BaseStep.waitSeconds(3);
    }

    @Test
    @Order(13)
    @DisplayName("İlanı Siliniyor...")
    public void deleteAd() {
        LogTest.info("İlan silme işlemi başlatılıyor...");

        WebElement deleteButton = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div/div[2]/div/div[2]/div[1]/div[4]/button[3]", TimeOut.SHORT.value);
        BaseStep.clickElement(deleteButton, "İlanı Sil Butonu");
        BaseStep.waitSeconds(1); 

        WebElement confirmDeleteButton = BaseStep.findElementXpathWithWait("//*[@id='root']/div/div/div[2]/div[2]/button[2]", TimeOut.SHORT.value);
        BaseStep.clickElement(confirmDeleteButton, "Evet, Sil Onay Butonu");

        LogTest.info("İlan başarıyla silindi.");
        BaseStep.waitSeconds(3);
    }
}
