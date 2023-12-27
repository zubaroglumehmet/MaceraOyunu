public class ToolStore extends NormalLoc{

    public ToolStore(Player player) {
        super(player, "Mağaza");
    }
        @Override
       public boolean onLocation(){
            System.out.println("Mağazaya Hoşgeldiniz:!");
            boolean ShowMenu=true;
            while (ShowMenu){
                System.out.println("1-Silahlar");
                System.out.println("2-Zırhlar");
                System.out.println("3-Çıkış Yap");
                System.out.print("Seçiminiz");
                int selectCase=input.nextInt();
                while (selectCase<1||selectCase>3){
                    System.out.print("Geçersiz Değer Tekrar Giriniz");
                    selectCase=input.nextInt();
                }
                switch (selectCase){
                    case 1:
                        printWeapon();
                        buyWeapon();
                        break;
                    case 2:
                        buyArmor();

                        break;
                    case 3:
                        System.out.println("Tekrar Gel");
                        ShowMenu=false;
                        break;
                }
            }
            return true;

        }
        public  void printWeapon(){
        System.out.println("-----Silahlar-----");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId()+"-"+w.getName() +  "<Para: " + w.getPrice()+"Hasar:" + w.getDamage() );
        }
        System.out.println("0-Çıkış Yap");


        }
        public void buyWeapon(){
            System.out.println("Bir Silahh Seçiniz");
            int selectWeaponID=input.nextInt();
            while (selectWeaponID<0|| selectWeaponID>  Weapon.weapons().length){
                System.out.print("Geçersiz Değer Tekrar Giriniz");
                selectWeaponID=input.nextInt();
            }
            if (selectWeaponID!=0){
                Weapon selectedWeapon=Weapon.getWeaponObjByID(selectWeaponID);

                if (selectedWeapon!=null){
                    if (selectedWeapon.getPrice()>this.getPlayer().getMoney()){
                        System.out.println("Yeterli Paranız Yok");
                    }
                    else {
                        System.out.println(selectedWeapon.getName()+"Silahını Satın Aldınız");
                        int balance=this.getPlayer().getMoney()-selectedWeapon.getPrice();
                        this.getPlayer().setMoney(balance);
                        System.out.println("Kalan Paranız :"+this.getPlayer().getMoney());
                        System.out.println("Önceki Silahınız"+this.getPlayer().getInventory().getWeapon().getName());
                        this.getPlayer().getInventory().setWeapon(selectedWeapon);
                        System.out.println("Yeni Silahınız"+this.getPlayer().getInventory().getWeapon().getName());
                    }
                }
            }

        }
        public void printArmor(){

            System.out.println("-----Zırhlar-----");
            for (Armor a : Armor.armors()) {
                System.out.println(a.getId()+" - "+a.getName() + "Para:" + a.getPrice() + "<Zırh: " + a.getBlock());

        }
            System.out.println("0-Çıkış Yap");




    } public void buyArmor(){
       System.out.println("Bir Zırh Seçiniz");
        int selectArmorID=input.nextInt();
        while (selectArmorID<0|| selectArmorID>  Armor.armors().length){
            System.out.print("Geçersiz Değer Tekrar Giriniz");
            selectArmorID=input.nextInt();
    }

       if (selectArmorID!=0){
           Armor selectedArmor=Armor.getArmorObjByID(selectArmorID);
           if (selectedArmor!=null){
               if (selectedArmor.getPrice()>this.getPlayer().getMoney()){
                   System.out.println("Yeterli Paranız Yok");}
               else {
                   System.out.println(selectedArmor.getName()+"zırhını satın aldınız ");
                   this.getPlayer().setMoney(this.getPlayer().getMoney()- selectedArmor.getPrice());
                   this.getPlayer().getInventory().setArmor(selectedArmor);
                   System.out.println("Kalan Bakiye: "+this.getPlayer().getMoney());
               }
           }
       }

    }
    }



