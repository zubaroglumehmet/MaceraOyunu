import  java.util.Scanner;
public class Game {
    private Scanner input=new Scanner(System.in);


    public  void start(){
        System.out.println("Macera Oyununa Hoşgeldiniz");
        System.out.println("Lütfen Bir İsim Giriniz");
     //   String playerName=input.nextLine();
        Player player =new Player("Mustfa");
        System.out.println("Sayın"+player.getName()+" HoşGeldiniz");
        System.out.println("Lütfen Bir Karakter Giriniz");
        player.selectChar();


        Location location=null;
        while (true){
            player.printInfo();
        System.out.println("Bölgeler");
        System.out.println("1-Güvenli Ev");
        System.out.println("2-Dükkan");
        System.out.println("3-Mağara--> Mağaraya Gir Dikkatlİ Ol Zombi Çıkabilir");
        System.out.println("4-Orman--> Ormana Gir Dikkatlİ Ol vampir Çıkabilir");
        System.out.println("5-Nehir--> Mağaraya Gir Dikkatlİ Ol Ayı Çıkabilir");
        System.out.println("0-Çıkış Yap Oyunu Sonlandır");


            System.out.println("Lütfen Gitmek İstediğinz Bölgeyi Seçiniz");
        int selectLoc=  input.nextInt();
        switch (selectLoc){
            case 0:
                location=null;
                break;
            case 1:
                location=new SafeHouse(player);
                break;
            case 2:
                location=new ToolStore(player);
                break;
            case 3:
                location=new Cave(player);
                        break;
            case 4:
                location=new Forrest(player);
                break;
            case 5:
                location=new River(player);
                break;
            default:
                System.out.println("Lütfen Geçerli BirBölge Giriniz");

        }

        if (location==null){
            System.out.println("Bu Karanlık Ve Sisli Adadan Çabuk Vazgeçtiniz");
            break;
        }

if (!location.onLocation()){
    System.out.println("GAME OVER");
    break;

   }
      }
       }

 }
