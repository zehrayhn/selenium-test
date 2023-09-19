Projeyi indirebilmek için Code bölümünden donwload zip kısmına tıklayarak projenin dosyasına ulaşabilirsiniz. Eclipse veya Intellij idea gibi programlarda çalıştırabilirsiniz.


Projeyi çalıştırmadan önce bir excel dosyası oluşturup bu excel dosyası içerisine gerekli verileri girmeniz gerekir. Oluşturulan excel dosyasını projeye dahil etmelisiniz.

![image](https://github.com/zehrayhn/selenium-test/assets/75533288/133f50a3-d6de-41c0-9c1d-734dd1066595)



Daha sonra projeye dahil edilen excel dosyasının yolunu Test klasörünün altında bulunan Test_Register içerisindeki fill_Out_Registration_Form adlı 
metodun içeriside bulunan ExcelDataReader'ın içerisine parametre olarak vermelisiniz.

![image](https://github.com/zehrayhn/selenium-test/assets/75533288/82a8af74-79c5-4e7d-b1c3-7a9fac99fdba)


Projeyi çalıştırmadan önce bir diğer dikkat edilmesi gereken nokta ise projede aktivasyon işlemleri arasında bulunan kamera ve kimlik çekimi adımları için sanal kamera kullanılması. 
Sanal kamera için Obs uygulaması indirilebilir. Obs uygulamasında iki tane sahne oluşturup bu sahnelere profil fotoğrafı ve kimlik fotoğrafı eklenmesi gerekir. Sahneler(fotoğraflar) arasında geçiş yapabilmek adına
sahnelere kısayol tuşu ataması yapılması gerekmekte. Ben projede profil fotoğrafından kimlik fotoğrafına geçiş yaparken klavyeden f7 tuşuna basma işlemini gerçekleştirdim. Projeyi çalıştırmak için kimlik fotoğrafına kısayol tuşu olarak f7 tuşunu atayabilirsiniz.


Projeyi çalıştırmak için test klasörü içerisindeki resources klasörünün altındaki textNG.xml dosyasını açmanız ve bu dosyayı koşmanız yeterlidir. 
textNG ile xml dosyası oluşturup, projedeki çalıştırılması istenilen test sınıflarını çalıştırılabilirsiniz. Çalıştırılması istenilen sınıfları belirtmek yeterlidir. 
textNG bir sınıf içerisindeki test metotlarından özel olarak seçilen test metotlarını da çalıştırabilir. 
