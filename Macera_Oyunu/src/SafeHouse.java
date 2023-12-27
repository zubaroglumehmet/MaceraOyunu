public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player){
        super(player,"Güvenli Ev");
    }
    @Override
 public    boolean onLocation(){
        System.out.println("Güvenli Evdesiniz");
        System.out.println("Caniniz Yenilendi");
        this.getPlayer().setHealth(this.getPlayer().getOrginalhealth());
        return true;
    }

}
