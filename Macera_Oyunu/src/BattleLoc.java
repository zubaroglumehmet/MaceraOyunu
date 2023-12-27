import java.util.Random;

public class BattleLoc extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    //private int firstHit;



    public BattleLoc(Player player, String name,Obstacle obstacle,String award,int maxObstacle) {
        super(player, name);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle=maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber=this.randomObstacleNumber();
        System.out.println("Şu An Buradasınız "+this.getName());
        System.out.println("Dikkatli Ol Burada"+obsNumber+"tane"+this.getObstacle().getName()+"yaşıyor !");
        System.out.println("<S>avaş ya da <K>aç");
        String selectCase=input.nextLine();
         selectCase=selectCase.toUpperCase();
        if (selectCase.equals("S")){
           if (combat(obsNumber)){
    System.out.println(this.getName()+"Tüm düşmanları yendiniz");
    System.exit(0);
            }
           return true;

        }
        if (this.getPlayer().getHealth()<=0){
            System.out.println("Öldünüz");
            return false;
        }
        return true;
    }
    public boolean combat(int obsNumber){
        for (int i =1; i<=obsNumber;i++){
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats(i);
         int  firstHit=firstHit();
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0){
                System.out.print("<V>ur veya <K>aç : ");
                String selectCombat=input.nextLine().toUpperCase();
                if (selectCombat.equals("V")){
                    if (firstHit==0)
                    {
                        System.out.println("Siz Vurdunuz ! ");
                    this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealth() > 0) {
                        System.out.println();
                        System.out.println("Canavar Size Vurdu");
                        int ObstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getHealth();
                        if (ObstacleDamage < 0) {
                            ObstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - ObstacleDamage);
                        afterHit();
                    }
                    }
                }else {
                    return false;
                }
            }
            if (getObstacle().getHealth()<getPlayer().getHealth())
                System.out.println("Düşmanı Yendiniz");
             System.out.println(this.getObstacle().getAward()+"Para Kazandınz");
            this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
            System.out.println("Güncel Paranız : "+this.getPlayer().getMoney());

        }
        return false;
    }

    private int firstHit() {
        return 0;
    }


    public void afterHit(){
        System.out.println("Canınız : "+this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName()+"Canı "+this.getObstacle().getHealth());
        System.out.println();





    }




    public void playerStats(){
        System.out.println("Oyuncu Değerleri");
        System.out.println("------------------");
        System.out.println("Sağlık: "+this.getPlayer().getHealth());
        System.out.println("Silah"+this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh"+this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama"+this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Hasar"+this.getPlayer().getTotalDamage());
        System.out.println("Para"+this.getPlayer().getMoney());
        }



    public void obstacleStats(int i){
    System.out.println(i+" "+this.getObstacle().getName()+"Değerleri");
    System.out.println("-------------------------------");
    System.out.println("Sağlık:"+this.getObstacle().getHealth());
    System.out.println("Hasar:"+this.getObstacle().getDamage());
    System.out.println("Ödül"+this.getObstacle().getAward());
}


    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle())+1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

}


