package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AkakceHomePage;
import util.DriverFactory;

public class AkakceSteps {

    AkakceHomePage akakceHomePage = new AkakceHomePage(DriverFactory.getDriver());

    @Given("Kullanıcı Akakçe mobil uygulamasını açar")
    public void kullanıcı_akakce_mobil_uygulamasını_açar() {
        DriverFactory.getDriver();
    }

    @When("Kullanıcı arama ikonuna tıklar")
    public void kullanıcı_arama_ikonuna_tıklar() {
        akakceHomePage.clickSearchIcon();
    }

    @When("Kullanıcı arama kutusuna {string} yazar ve aratır")
    public void kullanıcı_arama_kutusuna_yazar_ve_aratır(String product) {
        akakceHomePage.enterSearchText(product);
    }

    @When("Kullanıcı \"Filtrele\" butonuna tıklar")
    public void kullanıcı_filtrele_butonuna_tıklar() {
        akakceHomePage.clickFilterButton();
    }

    @When("Kullanıcı \"Alt Kategori -> Bilgisayar, Donanım\" seçeneğini seçer ve \"Ürünleri Gör\" butonuna tıklar")
    public void kullanıcı_alt_kategori_bilgisayar_donanim_seçeneğini_seçer_ve_ürünleri_gör_butonuna_tıklar() {
        akakceHomePage.selectCategory();
        akakceHomePage.clickViewProductsButton();
    }

    @When("Kullanıcı \"Sıralama seçeneklerinden En Yüksek Fiyat\" seçeneğini seçer")
    public void kullanıcı_sıralama_seçeneklerinden_en_yüksek_fiyat_seçeneğini_seçer() {
        akakceHomePage.selectSortingOption();
    }

    @When("Kullanıcı sonuç ekranında 10. ürüne tıklar ve \"Ürüne Git\" butonuna tıklar")
    public void kullanıcı_sonuç_ekranında_10_ürüne_tıklar_ve_ürüne_git_butonuna_tıklar() {
        akakceHomePage.clickProductItem();
        akakceHomePage.clickGoToProductButton();
    }

    @Then("Kullanıcı \"Satıcıya Git\" butonunun görüntülendiğini doğrular")
    public void kullanıcı_satıcıya_git_butonunun_görüntülendiğini_doğrular() {
        Assert.assertTrue(akakceHomePage.isGoToSellerButtonDisplayed(), "Satıcıya Git butonu görüntülenemedi!");
    }
}
