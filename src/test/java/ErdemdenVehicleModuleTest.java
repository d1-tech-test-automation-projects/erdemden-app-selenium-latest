import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ErdemdenVehicleModuleTest extends BaseStep {

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
    }

    @Test
    @Order(2)
    @DisplayName("Vasıta Sekmesine Git")
    public void NavigateToVehicle() {
        BaseStep.waitSeconds(3);
        LogTest.info("Vasıta sekmesi aranıyor...");
        WebElement vehicleTab = BaseStep.findElementXpathWithWait("//*[@id='root']/div/nav/div[2]/div[2]/button[3]",
                TimeOut.SHORT.value);
        BaseStep.clickElement(vehicleTab, "Vasıta sekmesine tıklandı");

        LogTest.info("Sayfa aşağı kaydırılıyor...");
        ((org.openqa.selenium.JavascriptExecutor) BaseStep.driver).executeScript("window.scrollBy(0, 500)");
        BaseStep.waitSeconds(1);
    }

    @Test
    @Order(3)
    @DisplayName("Vasıta Tipi Seçimi: Otomobil")
    public void selectCarType() {
        LogTest.info("Vasıta tipi alanından seçim yapılıyor...");
        String carTypeSelectXpath = "//select[contains(., 'Tüm Araç Tipleri')]";
        WebElement carTypeDropdown = BaseStep.findElementXpathWithWait(carTypeSelectXpath, TimeOut.SHORT.value);
        BaseStep.selectElementFromDropdown(carTypeDropdown, "Otomobil", "Vasıta Tipi Seçim İşlemi");
        BaseStep.waitSeconds(1);
        LogTest.info("Otomobil başarıyla seçildi.");
    }

    @Test
    @Order(4)
    @DisplayName("Vasıta Tipi Sıfırlama: Tüm Araç Tipleri")
    public void resetVehicleType() {
        LogTest.info("Vasıta tipi alanından seçim yapılıyor...");
        String vehicleTypeSelectXpath = "//select[contains(., 'Tüm Araç Tipleri')]";
        WebElement vehicleTypeDropdown = BaseStep.findElementXpathWithWait(vehicleTypeSelectXpath, TimeOut.SHORT.value);
        BaseStep.selectElementFromDropdown(vehicleTypeDropdown, "Tüm Araç Tipleri", "Vasıta Tipi Sıfırlama İşlemi");
        BaseStep.waitSeconds(1);
        LogTest.info("Tüm Araç Tipleri başarıyla seçildi.");
    }

    @Test
    @Order(5)
    @DisplayName("Fiyat Filtresi: Yüksekten Düşüğe")
    public void selectPriceHighToLow() {
        LogTest.info("Fiyat filtresi alanından seçim yapılıyor...");
        String priceFilterSelectXpath = "//select[option[@value='price_desc']]";
        WebElement priceDropdown = BaseStep.findElementXpathWithWait(priceFilterSelectXpath, TimeOut.SHORT.value);
        BaseStep.selectElementFromDropdown(priceDropdown, "Fiyat: Yüksekten Düşüğe", "Fiyat Filtresi Seçim İşlemi");
        BaseStep.waitSeconds(1);
        LogTest.info("Fiyat: Yüksekten Düşüğe başarıyla seçildi.");
    }

    @Test
    @Order(6)
    @DisplayName("Vasıta Araması: LAMBORGHİNİ")
    public void searchForLamborghini() {
        LogTest.info("Vasıta arama alanına veri girişi yapılıyor...");
        String searchFieldXpath = "//input[@placeholder='İlan ismi ara...']";
        WebElement searchInput = BaseStep.findElementXpathWithWait(searchFieldXpath, TimeOut.SHORT.value);
        BaseStep.clearAndType(searchInput, "LAMBORGHİNİ", "Vasıta Arama İşlemi");
        BaseStep.waitSeconds(1);
        LogTest.info("LAMBORGHİNİ araması başarıyla yapıldı.");
        BaseStep.clearAndType(searchInput, "", "Vasıta Arama Silme İşlemi");
        LogTest.info("Yazılan metin siliniyor...");

        BaseStep.waitSeconds(1);
        LogTest.info("LAMBORGHİNİ başarıyla silindi.");
    }

    @Test
    @Order(7)
    @DisplayName("İlan Ekle Butonuna Tıkla")
    public void clickAddAdvertisement() {
        LogTest.info("İlan ekle butonuna tıklanıyor...");
        String addAdButtonXpath = "//h3[text()='İlan Ekle']";
        WebElement addAdButton = BaseStep.findElementXpathWithWait(addAdButtonXpath, TimeOut.SHORT.value);
        BaseStep.clickElement(addAdButton, "İlan Ekleme Butonu Tıklama İşlemi");
        BaseStep.waitSeconds(1);
        LogTest.info("İlan ekle butonuna başarıyla tıklandı.");
    }

    @Test
    @Order(8)
    @DisplayName("İlan Başlığı Girişi: PORSCHE 911 GT3")
    public void enterCarListingTitle() {
        LogTest.info("İlan başlığı alanına veri girişi yapılıyor...");
        String titleFieldXpath = "//*[@id=\"root\"]/div/main/div/div[2]/div[2]/div/form/div[1]/div[1]/input";
        WebElement titleInput = BaseStep.findElementXpathWithWait(titleFieldXpath, TimeOut.SHORT.value);
        BaseStep.clearAndType(titleInput, "PORSCHE 911 GT3", "İlan Başlığı Giriş İşlemi");
        BaseStep.waitSeconds(1);
        LogTest.info("PORSCHE 911 GT3 başarıyla yazıldı.");
    }

    @Test
    @Order(9)
    @DisplayName("Fiyat Girişi: 31.500.000")
    public void enterCarPrice() {
        LogTest.info("Fiyat alanına veri girişi yapılıyor...");
        String priceFieldXpath = "//*[@id=\"root\"]/div/main/div/div[2]/div[2]/div/form/div[1]/div[2]/input";
        WebElement priceInput = BaseStep.findElementXpathWithWait(priceFieldXpath, TimeOut.SHORT.value);
        BaseStep.clearAndType(priceInput, "31.500.000", "Fiyat Giriş İşlemi");
        BaseStep.waitSeconds(1);
        LogTest.info("31.500.000 başarıyla yazıldı.");
    }

    @Test
    @Order(10)
    @DisplayName("İlan Açıklaması Girişi: Porsche Detayları")
    public void enterCarListingDescription() {
        LogTest.info("İlan açıklama alanına veri girişi yapılıyor...");
        String descriptionFieldXpath = "//*[@id=\"root\"]/div/main/div/div[2]/div[2]/div/form/div[1]/div[4]/textarea";
        WebElement descriptionInput = BaseStep.findElementXpathWithWait(descriptionFieldXpath, TimeOut.SHORT.value);
        String porscheDescription = "PORSCHE 911 GT3\n" +
                "ARAÇ KOMPLE DIŞ KORUMA ŞEFFAF PPF İLE KAPLANMIŞTIR\n" +
                "SHARK BLUE DIŞ RENK\n" +
                "CLUB SPORT PAKETİ(ROLL-BAR)\n" +
                "YARIŞ TİPİ KARBON KOLTUKLAR";
        BaseStep.clearAndType(descriptionInput, porscheDescription, "İlan Açıklama Giriş İşlemi");
        BaseStep.waitSeconds(1);
        LogTest.info("Porsche ilan açıklaması başarıyla yazıldı.");
    }

    @Test
    @Order(11)
    @DisplayName("Araç Bilgileri: Otomobil Seçimi")
    public void selectVehicleTypeCar() {
        LogTest.info("Araç tipi alanından seçim yapılıyor...");
        String vehicleTypeXpath = "//*[@id=\"root\"]/div/main/div/div[2]/div[2]/div/form/div[2]/div[1]/select";
        WebElement vehicleTypeDropdown = BaseStep.findElementXpathWithWait(vehicleTypeXpath, TimeOut.SHORT.value);
        BaseStep.selectElementFromDropdown(vehicleTypeDropdown, "Otomobil", "Araç Tipi Otomobil Seçim İşlemi");
        BaseStep.waitSeconds(1);
        LogTest.info("Otomobil başarıyla seçildi.");
    }

    @Test
    @Order(12)
    @DisplayName("Araç Bilgileri: Kasa Tipi Seçimi")
    public void selectBodyTypeCoupe() {
        LogTest.info("Kasa tipi alanından seçim yapılıyor...");
        String bodyTypeXpath = "//*[@id=\"root\"]/div/main/div/div[2]/div[2]/div/form/div[2]/div[2]/select";
        WebElement bodyTypeDropdown = BaseStep.findElementXpathWithWait(bodyTypeXpath, TimeOut.SHORT.value);
        BaseStep.selectElementFromDropdown(bodyTypeDropdown, "Coupe", "Kasa Tipi Coupe Seçim İşlemi");
        BaseStep.waitSeconds(1);
        LogTest.info("Coupe başarıyla seçildi.");
    }

    @Test
    @Order(13)
    @DisplayName("Araç Bilgileri: Marka Seçimi")
    public void selectBrandPorsche() {
        LogTest.info("Marka alanından seçim yapılıyor...");
        String brandSelectXpath = "//select[option[text()='Porsche']]";
        WebElement brandDropdown = BaseStep.findElementXpathWithWait(brandSelectXpath, TimeOut.SHORT.value);
        BaseStep.selectElementFromDropdown(brandDropdown, "Porsche", "Marka Porsche Seçim İşlemi");
        BaseStep.waitSeconds(1);
        LogTest.info("Porsche başarıyla seçildi.");
    }

    @Test
    @Order(14)
    @DisplayName("Araç Bilgileri: Model Seçimi")
    public void selectModel911() {
        LogTest.info("Model alanından seçim yapılıyor...");
        String modelSelectXpath = "//select[option[text()='911']]";
        WebElement modelDropdown = BaseStep.findElementXpathWithWait(modelSelectXpath, TimeOut.SHORT.value);
        BaseStep.selectElementFromDropdown(modelDropdown, "911", "Model 911 Seçim İşlemi");
        BaseStep.waitSeconds(1);
        LogTest.info("911 başarıyla seçildi.");
    }

    @Test
    @Order(15)
    @DisplayName("Araç Bilgileri: Paket Seçimi GT3")
    public void selectPackageGT3() {
        LogTest.info("Paket alanından seçim yapılıyor...");
        String packageSelectXpath = "//select[option[text()='GT3']]";
        WebElement packageDropdown = BaseStep.findElementXpathWithWait(packageSelectXpath, TimeOut.SHORT.value);
        BaseStep.selectElementFromDropdown(packageDropdown, "GT3", "Paket GT3 Seçim İşlemi");
        BaseStep.waitSeconds(1);
        LogTest.info("GT3 başarıyla seçildi.");
    }

    @Test
    @Order(16)
    @DisplayName("Araç Bilgileri: Yıl Girişi")
    public void enterVehicleYear() {
        LogTest.info("Yıl alanına veri girişi yapılıyor...");
        String yearFieldXpath = "//input[@placeholder='Örn: 2023']";
        WebElement yearInput = BaseStep.findElementXpathWithWait(yearFieldXpath, TimeOut.SHORT.value);
        BaseStep.clickElement(yearInput, "Yıl Alanına Odaklanma");
        BaseStep.clearAndType(yearInput, "2021", "Yıl Giriş İşlemi");
        BaseStep.waitSeconds(1);
        LogTest.info("2021 başarıyla yazıldı.");
    }

    @Test
    @Order(17)
    @DisplayName("Araç Bilgileri: KM Girişi")
    public void enterVehicleKM() {
        LogTest.info("KM alanına veri girişi yapılıyor...");
        String kmFieldXpath = "//input[@placeholder='Örn: 50.000']";
        WebElement kmInput = BaseStep.findElementXpathWithWait(kmFieldXpath, TimeOut.SHORT.value);
        BaseStep.clickElement(kmInput, "KM Alanına Odaklanma");
        BaseStep.clearAndType(kmInput, "6500", "KM Giriş İşlemi");
        BaseStep.waitSeconds(1);
        LogTest.info("6500 başarıyla yazıldı.");
    }

    @Test
    @Order(18)
    @DisplayName("Araç Bilgileri: Motor Gücü Girişi")
    public void enterVehicleEnginePower() {
        LogTest.info("Motor gücü alanına veri girişi yapılıyor...");
        String enginePowerFieldXpath = "//input[@placeholder='Örn: 150']";
        WebElement enginePowerInput = BaseStep.findElementXpathWithWait(enginePowerFieldXpath, TimeOut.SHORT.value);
        BaseStep.clickElement(enginePowerInput, "Motor Gücü Alanına Odaklanma");
        BaseStep.clearAndType(enginePowerInput, "510", "Motor Gücü Giriş İşlemi");
        BaseStep.waitSeconds(1);
        LogTest.info("510 başarıyla yazıldı.");
    }

    @Test
    @Order(19)
    @DisplayName("Araç Bilgileri: Motor Hacmi Girişi")
    public void enterVehicleEngineCapacity() {
        LogTest.info("Motor hacmi alanına veri girişi yapılıyor...");
        String engineCapacityFieldXpath = "//input[@placeholder='Örn: 1600']";
        WebElement engineCapacityInput = BaseStep.findElementXpathWithWait(engineCapacityFieldXpath,
                TimeOut.SHORT.value);
        BaseStep.clickElement(engineCapacityInput, "Motor Hacmi Alanına Odaklanma");
        BaseStep.clearAndType(engineCapacityInput, "3996", "Motor Hacmi Giriş İşlemi");
        BaseStep.waitSeconds(1);
        LogTest.info("3996 başarıyla yazıldı.");
    }

    @Test
    @Order(20)
    @DisplayName("Araç Bilgileri: Yakıt Seçimi Benzin")
    public void selectFuelTypeBenzin() {
        LogTest.info("Yakıt alanından seçim yapılıyor...");
        String fuelSelectXpath = "//select[option[text()='Benzin']]";
        WebElement fuelDropdown = BaseStep.findElementXpathWithWait(fuelSelectXpath, TimeOut.SHORT.value);
        BaseStep.selectElementFromDropdown(fuelDropdown, "Benzin", "Yakıt Benzin Seçim İşlemi");
        BaseStep.waitSeconds(1);
        LogTest.info("Benzin başarıyla seçildi.");
    }

    @Test
    @Order(21)
    @DisplayName("Araç Bilgileri: Vites Seçimi Otomatik")
    public void selectTransmissionOtomatik() {
        LogTest.info("Vites alanından seçim yapılıyor...");
        String transmissionSelectXpath = "//select[option[text()='Otomatik']]";
        WebElement transmissionDropdown = BaseStep.findElementXpathWithWait(transmissionSelectXpath,
                TimeOut.SHORT.value);
        BaseStep.selectElementFromDropdown(transmissionDropdown, "Otomatik", "Vites Otomatik Seçim İşlemi");
        BaseStep.waitSeconds(1);
        LogTest.info("Otomatik başarıyla seçildi.");
    }

    @Test
    @Order(22)
    @DisplayName("Araç Bilgileri: Renk Seçimi Mavi")
    public void selectColorMavi() {
        LogTest.info("Renk seçeneklerinden Mavi seçiliyor...");
        String colorMaviXpath = "//button[@title='Mavi']";
        WebElement colorButton = BaseStep.findElementXpathWithWait(colorMaviXpath, TimeOut.SHORT.value);
        BaseStep.clickElement(colorButton, "Mavi Renk Seçim İşlemi");
        BaseStep.waitSeconds(1);
        LogTest.info("Mavi renk başarıyla seçildi.");

        LogTest.info("Güvenlik seçeneklerine doğru aşağı kaydırılıyor...");
        ((org.openqa.selenium.JavascriptExecutor) BaseStep.driver).executeScript("window.scrollBy(0, 600)");
        BaseStep.waitSeconds(2);
    }

    @Test
    @Order(23)
    @DisplayName("Araç Özellikleri Seçiliyor...")
    public void selectAllVehicleFeatures() {
        LogTest.info("Araç özellikleri sırasıyla açılıp seçiliyor...");

        WebElement guvenlikHeader = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[2]/div[15]/div[1]/button", TimeOut.SHORT.value);
        ((org.openqa.selenium.JavascriptExecutor) BaseStep.driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", guvenlikHeader);
        BaseStep.waitSeconds(1);
        BaseStep.clickElement(guvenlikHeader, "Güvenlik Kategorisini Aç");
        BaseStep.waitSeconds(1);

        WebElement guvenlikSecim1 = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[2]/div[15]/div[1]/div/label[2]/input", TimeOut.SHORT.value);
        BaseStep.clickElement(guvenlikSecim1, "Güvenlik Seçim 1");

        WebElement guvenlikSecim2 = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[2]/div[15]/div[1]/div/label[16]/input", TimeOut.SHORT.value);
        BaseStep.clickElement(guvenlikSecim2, "Güvenlik Seçim 2");

        WebElement guvenlikSecim3 = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[2]/div[15]/div[1]/div/label[13]/input", TimeOut.SHORT.value);
        BaseStep.clickElement(guvenlikSecim3, "Güvenlik Seçim 3");
        
        guvenlikHeader = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[2]/div[15]/div[1]/button", TimeOut.SHORT.value);
        ((org.openqa.selenium.JavascriptExecutor) BaseStep.driver).executeScript("arguments[0].click();", guvenlikHeader);
        LogTest.info("Güvenlik Kategorisi Kapatıldı.");
        BaseStep.waitSeconds(1);

        WebElement icDonanimHeader = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[2]/div[15]/div[2]/button", TimeOut.SHORT.value);
        ((org.openqa.selenium.JavascriptExecutor) BaseStep.driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", icDonanimHeader);
        BaseStep.waitSeconds(1);
        BaseStep.clickElement(icDonanimHeader, "İç Donanım Kategorisini Aç");
        BaseStep.waitSeconds(1);

        WebElement icDonanimSecim1 = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[2]/div[15]/div[2]/div/label[6]/input", TimeOut.SHORT.value);
        BaseStep.clickElement(icDonanimSecim1, "İç Donanım Seçim 1");

        WebElement icDonanimSecim2 = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[2]/div[15]/div[2]/div/label[15]/input", TimeOut.SHORT.value);
        BaseStep.clickElement(icDonanimSecim2, "İç Donanım Seçim 2");

        WebElement icDonanimSecim3 = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[2]/div[15]/div[2]/div/label[18]/input", TimeOut.SHORT.value);
        BaseStep.clickElement(icDonanimSecim3, "İç Donanım Seçim 3");
        
        icDonanimHeader = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[2]/div[15]/div[2]/button", TimeOut.SHORT.value);
        ((org.openqa.selenium.JavascriptExecutor) BaseStep.driver).executeScript("arguments[0].click();", icDonanimHeader);
        LogTest.info("İç Donanım Kategorisi Kapatıldı.");
        BaseStep.waitSeconds(1);

        WebElement disDonanimHeader = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[2]/div[15]/div[3]/button", TimeOut.SHORT.value);
        ((org.openqa.selenium.JavascriptExecutor) BaseStep.driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", disDonanimHeader);
        BaseStep.waitSeconds(1);
        BaseStep.clickElement(disDonanimHeader, "Dış Donanım Kategorisini Aç");
        BaseStep.waitSeconds(1);

        WebElement disDonanimSecim1 = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[2]/div[15]/div[3]/div/label[2]/input", TimeOut.SHORT.value);
        BaseStep.clickElement(disDonanimSecim1, "Dış Donanım Seçim 1");

        WebElement disDonanimSecim2 = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[2]/div[15]/div[3]/div/label[5]/input", TimeOut.SHORT.value);
        BaseStep.clickElement(disDonanimSecim2, "Dış Donanım Seçim 2");

        WebElement disDonanimSecim3 = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[2]/div[15]/div[3]/div/label[7]/input", TimeOut.SHORT.value);
        BaseStep.clickElement(disDonanimSecim3, "Dış Donanım Seçim 3");
        
        disDonanimHeader = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[2]/div[15]/div[3]/button", TimeOut.SHORT.value);
        ((org.openqa.selenium.JavascriptExecutor) BaseStep.driver).executeScript("arguments[0].click();", disDonanimHeader);
        LogTest.info("Dış Donanım Kategorisi Kapatıldı.");
        BaseStep.waitSeconds(1);

        WebElement multimedyaHeader = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[2]/div[15]/div[4]/button", TimeOut.SHORT.value);
        ((org.openqa.selenium.JavascriptExecutor) BaseStep.driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", multimedyaHeader);
        BaseStep.waitSeconds(1);
        BaseStep.clickElement(multimedyaHeader, "Multimedya Kategorisini Aç");
        BaseStep.waitSeconds(1);

        WebElement multimedyaSecim1 = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[2]/div[15]/div[4]/div/label[2]/input", TimeOut.SHORT.value);
        BaseStep.clickElement(multimedyaSecim1, "Multimedya Seçim 1");

        WebElement multimedyaSecim2 = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[2]/div[15]/div[4]/div/label[5]/input", TimeOut.SHORT.value);
        BaseStep.clickElement(multimedyaSecim2, "Multimedya Seçim 2");

        WebElement multimedyaSecim3 = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[2]/div[15]/div[4]/div/label[8]/input", TimeOut.SHORT.value);
        BaseStep.clickElement(multimedyaSecim3, "Multimedya Seçim 3");
        
        multimedyaHeader = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div[2]/div[2]/div/form/div[2]/div[15]/div[4]/button", TimeOut.SHORT.value);
        ((org.openqa.selenium.JavascriptExecutor) BaseStep.driver).executeScript("arguments[0].click();", multimedyaHeader);
        LogTest.info("Multimedya Kategorisi Kapatıldı.");
        BaseStep.waitSeconds(1);

        LogTest.info("Tüm araç özellikleri sırasıyla seçildi.");
        BaseStep.waitSeconds(2);
    }

    @Test
    @Order(24)
    @DisplayName("Araç İlanı: Dosya Yükleme ve Yayınlama")
    public void uploadFilesAndPublish() {
        LogTest.info("Dosya yükleme ve yayınlama işlemi başlatılıyor...");

        WebElement pdfUpload = BaseStep.findElementXpathWithWait("//button[contains(., 'PDF Yükle')]", TimeOut.SHORT.value);
        BaseStep.waitSeconds(1);
        BaseStep.uploadFileViaDialog(pdfUpload, "DÖKÜMAN.pdf", "Ekspertiz Raporu (PDF)");
        BaseStep.waitSeconds(4);

        WebElement imageUpload = BaseStep.findElementXpathWithWait("//button[contains(., 'Fotoğraf Ekle')]", TimeOut.SHORT.value);
        BaseStep.waitSeconds(1);
        BaseStep.uploadFileViaDialog(imageUpload, "araba1.png", "Araç Fotoğrafı");
        BaseStep.waitSeconds(3);

        WebElement publishButton = BaseStep.findElementXpathWithWait("//button[contains(., 'İlanı Yayınla')]", TimeOut.SHORT.value);
        BaseStep.waitSeconds(1);
        BaseStep.clickElement(publishButton, "İlanı Yayınla Butonu");

        LogTest.info("İlan yayınlama işlemi tamamlandı.");
        BaseStep.waitSeconds(5);
    }

    @Test
    @Order(25)
    @DisplayName("Araç İlanı: Arama ve Düzenleme")
    public void searchAndEditVehicleAd() {
        LogTest.info("Araç ilanı arama ve düzenleme işlemi başlatılıyor...");
        WebElement searchInput = BaseStep.findElementXpathWithWait("//input[@placeholder='İlan ismi ara...']", TimeOut.SHORT.value);
        BaseStep.clearAndType(searchInput, "PORSCHE 911 GT3", "İlan Arama");
        BaseStep.waitSeconds(2);

        WebElement adResult = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div/div[2]/div[2]/div[2]/div", TimeOut.SHORT.value);
        BaseStep.clickElement(adResult, "Arama Sonucu: Araç İlanı");
        BaseStep.waitSeconds(2);

        WebElement editButton = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div/div/div[2]/div[1]/div[4]/button[1]", TimeOut.SHORT.value);
        BaseStep.clickElement(editButton, "Düzenle Butonu");
        BaseStep.waitSeconds(1);

        WebElement priceInput = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div/div/form/div[1]/div[2]/input", TimeOut.SHORT.value);
        BaseStep.clearAndType(priceInput, "25000000", "Güncel Fiyat");

        WebElement saveButton = BaseStep.findElementXpathWithWait("//*[@id='root']/div/main/div/div/div/form/div[5]/button", TimeOut.SHORT.value);
        BaseStep.clickElement(saveButton, "Değişiklikleri Kaydet Butonu");

        LogTest.info("Araç ilanı başarıyla düzenlendi.");
        BaseStep.waitSeconds(3);
    }

    @Test
    @Order(26)
    @DisplayName("Araç İlanı: Silme")
    public void deleteVehicleAd() {
        LogTest.info("Araç ilanı silme işlemi başlatılıyor...");

        WebElement deleteButton = BaseStep.findElementXpathWithWait("//*[@id=\'root\']/div/main/div/div/div/div[2]/div[1]/div[4]/button[3]", TimeOut.SHORT.value);
        BaseStep.clickElement(deleteButton, "İlanı Sil Butonu");
        BaseStep.waitSeconds(1);

        WebElement confirmDeleteButton = BaseStep.findElementXpathWithWait("//*[@id='root']/div/div/div[2]/div[2]/button[2]", TimeOut.SHORT.value);
        BaseStep.clickElement(confirmDeleteButton, "Evet, Sil Onay Butonu");

        LogTest.info("Araç ilanı başarıyla silindi.");
        BaseStep.waitSeconds(3);
    }
}
