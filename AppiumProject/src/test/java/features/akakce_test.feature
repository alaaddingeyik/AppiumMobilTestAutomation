Feature: Akakce Mobil Uygulaması Testi

  @Test1
  Scenario: Laptop Arama ve Satıcıya Git Butonunu Doğrulama
  Given Kullanıcı Akakçe mobil uygulamasını açar
  And Kullanıcı arama ikonuna tıklar
  And Kullanıcı arama kutusuna "Laptop" yazar ve aratır
  And Kullanıcı "Filtrele" butonuna tıklar
  And Kullanıcı "Alt Kategori -> Bilgisayar, Donanım" seçeneğini seçer ve "Ürünleri Gör" butonuna tıklar
  And Kullanıcı "Sıralama seçeneklerinden En Yüksek Fiyat" seçeneğini seçer
  And Kullanıcı sonuç ekranında 10. ürüne tıklar ve "Ürüne Git" butonuna tıklar
  Then Kullanıcı "Satıcıya Git" butonunun görüntülendiğini doğrular
