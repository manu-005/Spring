package com.xworkz.customBean.config;


import com.xworkz.customBean.components.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.xworkz.customBean")
public class CustomBeanConfiguration {

    public CustomBeanConfiguration(){
        System.out.println("custom bean configuration object created..");
    }

    @Bean("b1")
    public List<Laptop> getLaptop(){

        List list = new ArrayList();

        list.add(new Laptop(101,"asus","vivo book","asus","7538","Manoj",35000,8));
        list.add(new Laptop(102,"hp","pavilion","hp","abc1","Ravi",45000,16));
        list.add(new Laptop(103,"dell","inspiron","dell","xyz2","Kiran",52000,8));
        list.add(new Laptop(104,"lenovo","ideapad","lenovo","lm33","Arun",48000,12));
        list.add(new Laptop(105,"acer","swift","acer","sw55","Vijay",39000,8));
        list.add(new Laptop(106,"apple","macbook","apple","mb13","Sam",95000,16));
        list.add(new Laptop(107,"microsoft","modern","msi","md45","Rohit",68000,16));
        list.add(new Laptop(108,"samsung","galaxy book","samsung","gb14","Suresh",73000,8));
        list.add(new Laptop(109,"lg","gram","lg","gr17","Naveen",82000,16));
        list.add(new Laptop(110,"window","w12","vaio","sx14","Ramesh",64000,12));
        list.add(new Laptop(111,"redmi","gaming","gaming","jjj","Harsha",42000,8));
        list.add(new Laptop(112,"realme","book","realme","rb13","Karthik",36000,8));
        list.add(new Laptop(113,"infinix","inbook","infinix","ib15","Prasad",34000,8));
        list.add(new Laptop(114,"xiaomi","mi notebook","xiaomi","mn14","Shivu",47000,16));
        list.add(new Laptop(115,"honor","magicbook","honor","mb15","Yogesh",52000,8));

        return list;
    }

    @Bean("b27")
    public List<Fridge> getFridge() {
        List<Fridge> list = new ArrayList<>();
        list.add(new Fridge(2701,"LG",300,"Double Door","Silver",40000,true,"Manoj"));
        list.add(new Fridge(2702,"Samsung",250,"Single Door","White",35000,true,"Ravi"));
        list.add(new Fridge(2703,"Whirlpool",280,"Double Door","Black",42000,false,"Kiran"));
        list.add(new Fridge(2704,"Godrej",320,"Single Door","Grey",38000,true,"Arun"));
        list.add(new Fridge(2705,"Haier",300,"Double Door","Blue",41000,false,"Vijay"));
        list.add(new Fridge(2706,"LG",250,"Single Door","Silver",36000,true,"Sam"));
        list.add(new Fridge(2707,"Samsung",280,"Double Door","White",43000,false,"Rohit"));
        list.add(new Fridge(2708,"Whirlpool",300,"Single Door","Black",39000,true,"Suresh"));
        list.add(new Fridge(2709,"Godrej",320,"Double Door","Grey",44000,true,"Naveen"));
        list.add(new Fridge(2710,"Haier",280,"Single Door","Blue",37000,false,"Ramesh"));
        list.add(new Fridge(2711,"LG",300,"Double Door","Silver",42000,true,"Harsha"));
        list.add(new Fridge(2712,"Samsung",250,"Single Door","White",36000,true,"Karthik"));
        list.add(new Fridge(2713,"Whirlpool",280,"Double Door","Black",43000,false,"Prasad"));
        list.add(new Fridge(2714,"Godrej",320,"Single Door","Grey",39000,true,"Shivu"));
        list.add(new Fridge(2715,"Haier",300,"Double Door","Blue",44000,false,"Yogesh"));
        return list;
    }

    @Bean("b28")
    public List<Fan> getFan() {
        List<Fan> list = new ArrayList<>();
        list.add(new Fan(2801,"Crompton","Ceiling",3,"White",3,2500,"CF101"));
        list.add(new Fan(2802,"Havells","Table",2,"Black",3,1200,"TF102"));
        list.add(new Fan(2803,"Usha","Pedestal",3,"Grey",3,2000,"PF103"));
        list.add(new Fan(2804,"Orient","Ceiling",3,"Brown",3,2700,"CF104"));
        list.add(new Fan(2805,"Crompton","Wall",2,"White",3,1800,"WF105"));
        list.add(new Fan(2806,"Havells","Table",2,"Black",3,1500,"TF106"));
        list.add(new Fan(2807,"Usha","Ceiling",3,"Grey",3,2600,"CF107"));
        list.add(new Fan(2808,"Orient","Pedestal",3,"White",3,2100,"PF108"));
        list.add(new Fan(2809,"Crompton","Wall",2,"Brown",3,1900,"WF109"));
        list.add(new Fan(2810,"Havells","Ceiling",3,"Black",3,2500,"CF110"));
        list.add(new Fan(2811,"Usha","Table",2,"White",3,1400,"TF111"));
        list.add(new Fan(2812,"Orient","Pedestal",3,"Grey",3,2300,"PF112"));
        list.add(new Fan(2813,"Crompton","Ceiling",3,"White",3,2600,"CF113"));
        list.add(new Fan(2814,"Havells","Wall",2,"Black",3,1800,"WF114"));
        list.add(new Fan(2815,"Usha","Table",2,"Grey",3,1500,"TF115"));
        return list;
    }

    @Bean("b29")
    public List<Cupboard> getCupboard() {
        List<Cupboard> list = new ArrayList<>();
        list.add(new Cupboard(2901,"Wood",4,"Brown",true,12000,"Godrej","CB101"));
        list.add(new Cupboard(2902,"Metal",3,"White",false,10000,"LG","CB102"));
        list.add(new Cupboard(2903,"Wood",5,"Black",true,15000,"Samsung","CB103"));
        list.add(new Cupboard(2904,"Plastic",3,"Grey",false,8000,"Usha","CB104"));
        list.add(new Cupboard(2905,"Metal",4,"Silver",true,13000,"Godrej","CB105"));
        list.add(new Cupboard(2906,"Wood",5,"Brown",false,14000,"LG","CB106"));
        list.add(new Cupboard(2907,"Plastic",3,"White",true,9000,"Samsung","CB107"));
        list.add(new Cupboard(2908,"Metal",4,"Black",false,12000,"Usha","CB108"));
        list.add(new Cupboard(2909,"Wood",5,"Grey",true,16000,"Godrej","CB109"));
        list.add(new Cupboard(2910,"Plastic",3,"Silver",false,8500,"LG","CB110"));
        list.add(new Cupboard(2911,"Metal",4,"Brown",true,12500,"Samsung","CB111"));
        list.add(new Cupboard(2912,"Wood",5,"White",false,14500,"Usha","CB112"));
        list.add(new Cupboard(2913,"Plastic",3,"Black",true,9500,"Godrej","CB113"));
        list.add(new Cupboard(2914,"Metal",4,"Grey",false,13500,"LG","CB114"));
        list.add(new Cupboard(2915,"Wood",5,"Silver",true,15500,"Samsung","CB115"));
        return list;
    }

    @Bean("b30")
    public List<Chair> getChair() {
        List<Chair> list = new ArrayList<>();
        list.add(new Chair(3001,"Wood","Brown","Dining",false,3500,"Godrej","CH101"));
        list.add(new Chair(3002,"Plastic","White","Office",true,1800,"LG","CH102"));
        list.add(new Chair(3003,"Metal","Black","Dining",false,2500,"Samsung","CH103"));
        list.add(new Chair(3004,"Wood","Grey","Office",true,4000,"Usha","CH104"));
        list.add(new Chair(3005,"Plastic","Blue","Gaming",true,3000,"Godrej","CH105"));
        list.add(new Chair(3006,"Metal","Brown","Dining",false,3500,"LG","CH106"));
        list.add(new Chair(3007,"Wood","White","Office",true,3800,"Samsung","CH107"));
        list.add(new Chair(3008,"Plastic","Black","Gaming",true,2800,"Usha","CH108"));
        list.add(new Chair(3009,"Metal","Grey","Dining",false,3300,"Godrej","CH109"));
        list.add(new Chair(3010,"Wood","Silver","Office",true,4200,"LG","CH110"));
        list.add(new Chair(3011,"Plastic","Brown","Gaming",true,3100,"Samsung","CH111"));
        list.add(new Chair(3012,"Metal","White","Dining",false,3400,"Usha","CH112"));
        list.add(new Chair(3013,"Wood","Black","Office",true,3600,"Godrej","CH113"));
        list.add(new Chair(3014,"Plastic","Grey","Gaming",true,2900,"LG","CH114"));
        list.add(new Chair(3015,"Metal","Silver","Dining",false,3500,"Samsung","CH115"));
        return list;
    }


    @Bean("b2")
    public List<Mobile> getMobile() {

        List list = new ArrayList();

        list.add(new Mobile(201,"Samsung","Galaxy S23",65000,8,256,"Black","Manoj"));
        list.add(new Mobile(202,"Apple","iPhone 14",78000,6,128,"Blue","Ravi"));
        list.add(new Mobile(203,"OnePlus","Nord CE3",26000,8,128,"Grey","Kiran"));
        list.add(new Mobile(204,"Vivo","V29 Pro",32000,12,256,"Pink","Arun"));
        list.add(new Mobile(205,"Oppo","Reno 11",30000,8,128,"Green","Vijay"));
        list.add(new Mobile(206,"Realme","Realme 11 Pro",24000,8,256,"Black","Sam"));
        list.add(new Mobile(207,"Poco","X6 Pro",29000,8,256,"Yellow","Rohit"));
        list.add(new Mobile(208,"Xiaomi","Mi 13 Lite",27000,6,128,"Blue","Suresh"));
        list.add(new Mobile(209,"Motorola","Edge 40",33000,8,256,"Grey","Naveen"));
        list.add(new Mobile(210,"Nothing","Phone 2",42000,12,256,"White","Ramesh"));
        list.add(new Mobile(211,"Infinix","GT 20",19000,8,128,"Black","Harsha"));
        list.add(new Mobile(212,"Tecno","Phantom X",22000,8,256,"Gold","Karthik"));
        list.add(new Mobile(213,"iQOO","Z7 Pro",25000,8,128,"Blue","Prasad"));
        list.add(new Mobile(214,"Lava","Agni 2",21000,8,256,"Green","Shivu"));
        list.add(new Mobile(215,"Honor","X9B",23000,8,128,"Orange","Yogesh"));

        return list;
    }

    @Bean("b3")
    public List<AirConditioner> getAirConditioners() {

        List list = new ArrayList();

        list.add(new AirConditioner(201, "Samsung", 1, "Split", true, 32000, "SPLT100", "White"));
        list.add(new AirConditioner(202, "LG", 1, "Window", false, 28000, "LGW200", "Grey"));
        list.add(new AirConditioner(203, "Voltas", 1, "Split", true, 35000, "VLT300", "White"));
        list.add(new AirConditioner(204, "Daikin", 1, "Split", true, 42000, "DKN400", "Blue"));
        list.add(new AirConditioner(205, "Whirlpool", 1, "Window", false, 27000, "WHR500", "White"));
        list.add(new AirConditioner(206, "Carrier", 1, "Split", true, 39000, "CRR600", "Silver"));
        list.add(new AirConditioner(207, "BlueStar", 1, "Split", true, 36000, "BST700", "White"));
        list.add(new AirConditioner(208, "Hitachi", 1, "Window", false, 30000, "HTC800", "Grey"));
        list.add(new AirConditioner(209, "Panasonic", 1, "Split", true, 41000, "PNS900", "White"));
        list.add(new AirConditioner(210, "Onida", 1, "Window", false, 25000, "OND910", "Black"));
        list.add(new AirConditioner(211, "Haier", 1, "Split", true, 34000, "HAR920", "White"));
        list.add(new AirConditioner(212, "Godrej", 1, "Window", false, 26000, "GDJ930", "Silver"));
        list.add(new AirConditioner(213, "TCL", 1, "Split", true, 33000, "TCL940", "Blue"));
        list.add(new AirConditioner(214, "Lloyd", 1, "Window", false, 24000, "LLD950", "White"));
        list.add(new AirConditioner(215, "Midea", 1, "Split", true, 35000, "MDA960", "Silver"));

        return list;
    }

    @Bean("b4")
    public List<WaterBottle> getWaterBottle() {

        List list = new ArrayList();

        list.add(new WaterBottle(301,"Milton","Steel","Silver",1000,true,750,"Manoj"));
        list.add(new WaterBottle(302,"Cello","Plastic","Blue",1500,false,250,"Ravi"));
        list.add(new WaterBottle(303,"Tupperware","Plastic","Pink",750,false,300,"Kiran"));
        list.add(new WaterBottle(304,"CamelBak","Steel","Black",1000,true,900,"Arun"));
        list.add(new WaterBottle(305,"Hydro Flask","Steel","Red",1200,true,1500,"Vijay"));
        list.add(new WaterBottle(306,"Solimo","Plastic","Green",1000,false,200,"Sam"));
        list.add(new WaterBottle(307,"Pigeon","Copper","Brown",1000,true,850,"Rohit"));
        list.add(new WaterBottle(308,"Signoraware","Plastic","Yellow",750,false,280,"Suresh"));
        list.add(new WaterBottle(309,"Prestige","Steel","Grey",1500,true,1100,"Naveen"));
        list.add(new WaterBottle(310,"H2O","Plastic","Purple",1000,false,220,"Ramesh"));
        list.add(new WaterBottle(311,"Nike","Steel","Blue",1200,true,1300,"Harsha"));
        list.add(new WaterBottle(312,"Decathlon","Plastic","Green",750,false,350,"Karthik"));
        list.add(new WaterBottle(313,"Urban Gear","Steel","Black",1800,true,1600,"Prasad"));
        list.add(new WaterBottle(314,"Speedex","Aluminium","Orange",1000,false,400,"Shivu"));
        list.add(new WaterBottle(315,"Borosil","Glass","Transparent",900,false,500,"Yogesh"));

        return list;
    }
    @Bean("b5")
    public List<Watch> getWatch() {

        List list = new ArrayList();

        list.add(new Watch(401,"Fossil","FS5405","Black",true,8500,"Leather",false));
        list.add(new Watch(402,"Casio","G-Shock GA210","Red",true,9200,"Rubber",false));
        list.add(new Watch(403,"Titan","Edge 2023","Brown",true,7800,"Leather",false));
        list.add(new Watch(404,"Sonata","Super Fibre","Blue",false,1200,"Rubber",false));
        list.add(new Watch(405,"Timex","Weekender","Green",false,3500,"Nylon",false));
        list.add(new Watch(406,"Apple","Watch Series 8","White",true,42000,"Silicone",true));
        list.add(new Watch(407,"Samsung","Galaxy Watch 6","Black",true,32000,"Silicone",true));
        list.add(new Watch(408,"Boat","Wave Call","Grey",false,2500,"Silicone",true));
        list.add(new Watch(409,"Fire-Boltt","Phoenix Ultra","Rose Gold",false,1800,"Metal",true));
        list.add(new Watch(410,"Noise","ColorFit Ultra","Silver",true,3000,"Silicone",true));
        list.add(new Watch(411,"Seiko","Prospex","Black",true,27000,"Metal",false));
        list.add(new Watch(412,"Citizen","Eco-Drive","Blue",true,19000,"Metal",false));
        list.add(new Watch(413,"Rolex","Submariner","Black",true,850000,"Steel",false));
        list.add(new Watch(414,"Omega","Seamaster","Blue",true,450000,"Metal",false));
        list.add(new Watch(415,"Tissot","PRX","Green",true,35000,"Metal",false));

        return list;
    }

    @Bean("b6")
    public List<WashingMachine> getWashingMachine() {

        List list = new ArrayList();

        list.add(new WashingMachine(501,"LG","Front Load",7,"White",32000,true,"FL2023"));
        list.add(new WashingMachine(502,"Samsung","Top Load",6,"Grey",25000,false,"TLX12"));
        list.add(new WashingMachine(503,"Whirlpool","Front Load",8,"Silver",36000,true,"WPL80"));
        list.add(new WashingMachine(504,"Bosch","Front Load",7,"White",42000,true,"BOS70"));
        list.add(new WashingMachine(505,"IFB","Top Load",6,"Black",28000,false,"IFBTL6"));
        list.add(new WashingMachine(506,"Haier","Front Load",7,"Blue",30000,true,"HFR70"));
        list.add(new WashingMachine(507,"Panasonic","Top Load",6,"Grey",23000,false,"PNTL6"));
        list.add(new WashingMachine(508,"Onida","Front Load",7,"White",27000,true,"ONFL7"));
        list.add(new WashingMachine(509,"Godrej","Top Load",6,"Silver",24000,false,"GDTL6"));
        list.add(new WashingMachine(510,"Lloyd","Front Load",7,"Red",31000,true,"LLFL7"));
        list.add(new WashingMachine(511,"BPL","Top Load",5,"White",19000,false,"BPLTL5"));
        list.add(new WashingMachine(512,"Kelvinator","Front Load",7,"Grey",26000,true,"KFL70"));
        list.add(new WashingMachine(513,"Videocon","Top Load",6,"Blue",21000,false,"VDTL6"));
        list.add(new WashingMachine(514,"Mitashi","Front Load",7,"Silver",25000,true,"MTFL7"));
        list.add(new WashingMachine(515,"Intex","Top Load",6,"Black",18000,false,"ITTL6"));

        return list;
    }
    @Bean("b7")
    public List<Wallet> getWallet() {

        List list = new ArrayList();

        list.add(new Wallet(601,"WildHorn","Leather","Brown",4,899,true,"Manoj"));
        list.add(new Wallet(602,"UrbanForest","Synthetic","Black",3,750,false,"Ravi"));
        list.add(new Wallet(603,"Tommy Hilfiger","Leather","Tan",5,2499,true,"Kiran"));
        list.add(new Wallet(604,"Woodland","Canvas","Green",3,999,false,"Arun"));
        list.add(new Wallet(605,"Hornbull","Leather","Dark Brown",4,699,true,"Vijay"));
        list.add(new Wallet(606,"Puma","Fabric","Grey",2,599,false,"Sujay"));
        list.add(new Wallet(607,"Nike","Synthetic","Blue",3,799,false,"Rohit"));
        list.add(new Wallet(608,"Titan","Leather","Black",4,1599,true,"Suresh"));
        list.add(new Wallet(609,"Fossil","Leather","Brown",6,3499,true,"Naveen"));
        list.add(new Wallet(610,"Baggit","Vegan Leather","Red",3,899,false,"Ramesh"));
        list.add(new Wallet(611,"Lavie","Vegan Leather","Pink",4,999,true,"Harsha"));
        list.add(new Wallet(612,"Hidesign","Premium Leather","Maroon",5,3999,true,"Prasad"));
        list.add(new Wallet(613,"Allen Solly","Leather","Navy Blue",4,1299,false,"Shivu"));
        list.add(new Wallet(614,"Polestar","Fabric","Grey",2,550,false,"Yogesh"));
        list.add(new Wallet(615,"American Tourister","Synthetic","Black",3,699,true,"Karthik"));

        return list;
    }
    @Bean("b8")
    public List<Umbrella> getUmbrella() {

        List list = new ArrayList();

        list.add(new Umbrella(701,"Black","Foldable","Flying Horse",1200,true,"Polyester",24));
        list.add(new Umbrella(702,"Blue","Stick","Wildcraft",900,false,"Nylon",28));
        list.add(new Umbrella(703,"Red","Foldable","Fastrack",1100,true,"Polyester",22));
        list.add(new Umbrella(704,"Green","Stick","Croma",800,false,"Nylon",30));
        list.add(new Umbrella(705,"Yellow","Foldable","Cello",1000,true,"Polyester",26));
        list.add(new Umbrella(706,"Grey","Stick","Puma",950,false,"Nylon",28));
        list.add(new Umbrella(707,"Pink","Foldable","Nike",1200,true,"Polyester",24));
        list.add(new Umbrella(708,"Purple","Stick","Reebok",850,false,"Nylon",30));
        list.add(new Umbrella(709,"Orange","Foldable","Adidas",1100,true,"Polyester",26));
        list.add(new Umbrella(710,"White","Stick","WildHorn",900,false,"Nylon",28));
        list.add(new Umbrella(711,"Black","Foldable","Fastrack",1000,true,"Polyester",24));
        list.add(new Umbrella(712,"Blue","Stick","Croma",950,false,"Nylon",30));
        list.add(new Umbrella(713,"Green","Foldable","Cello",1050,true,"Polyester",26));
        list.add(new Umbrella(714,"Red","Stick","Puma",900,false,"Nylon",28));
        list.add(new Umbrella(715,"Black","Foldable","Nike",1150,true,"Polyester",24));

        return list;
    }

    @Bean("b9")
    public List<Table> getTable() {

        List list = new ArrayList();

        list.add(new Table(901,"Wood","Brown",75,120,4500,"Nilkamal",true));
        list.add(new Table(902,"Metal","Black",70,110,3500,"Godrej",false));
        list.add(new Table(903,"Glass","Transparent",72,100,5500,"HomeTown",true));
        list.add(new Table(904,"Wood","Dark Brown",80,130,6000,"Durian",false));
        list.add(new Table(905,"Plastic","White",65,90,1500,"Cello",true));
        list.add(new Table(906,"Metal","Grey",75,120,4000,"Featherlite",false));
        list.add(new Table(907,"Wood","Oak",78,125,7000,"RoyalOak",false));
        list.add(new Table(908,"Glass","Black",70,110,5000,"UrbanLadder",true));
        list.add(new Table(909,"Plastic","Blue",68,95,1800,"Nilkamal",true));
        list.add(new Table(910,"Metal","Silver",75,120,4500,"Godrej",false));
        list.add(new Table(911,"Wood","Natural",72,110,5200,"Durian",false));
        list.add(new Table(912,"Glass","Clear",70,100,4800,"HomeTown",true));
        list.add(new Table(913,"Wood","Brown",75,115,4300,"Nilkamal",true));
        list.add(new Table(914,"Plastic","Green",65,90,1600,"Cello",true));
        list.add(new Table(915,"Metal","Black",78,125,5500,"Featherlite",false));

        return list;
    }
    @Bean("b10")
    public List<Television> getTelevision() {

        List list = new ArrayList();

        list.add(new Television(801,"Samsung","QLED 55",55,"QLED",true,75000,"Manoj"));
        list.add(new Television(802,"LG","OLED 48",48,"OLED",true,68000,"Ravi"));
        list.add(new Television(803,"Sony","Bravia 50",50,"LED",true,72000,"Kiran"));
        list.add(new Television(804,"Panasonic","VX 42",42,"LED",false,35000,"Arun"));
        list.add(new Television(805,"TCL","P715 55",55,"LED",true,40000,"Vijay"));
        list.add(new Television(806,"Vu","Premium 50",50,"LED",true,42000,"Sam"));
        list.add(new Television(807,"OnePlus","U1S 50",50,"LED",true,50000,"Rohit"));
        list.add(new Television(808,"Hisense","A6G 43",43,"LED",false,28000,"Suresh"));
        list.add(new Television(809,"Kodak","50UHDX",50,"LED",true,38000,"Naveen"));
        list.add(new Television(810,"Samsung","TU8000 65",65,"QLED",true,95000,"Ramesh"));
        list.add(new Television(811,"LG","NanoCell 55",55,"LED",true,72000,"Harsha"));
        list.add(new Television(812,"Sony","X80J 50",50,"LED",true,75000,"Karthik"));
        list.add(new Television(813,"Panasonic","HX 42",42,"LED",false,33000,"Prasad"));
        list.add(new Television(814,"TCL","C715 55",55,"LED",true,41000,"Shivu"));
        list.add(new Television(815,"Vu","Cinema 50",50,"LED",true,47000,"Yogesh"));

        return list;
    }
    @Bean("b11")
    public List<Speaker> getSpeaker() {

        List list = new ArrayList();

        list.add(new Speaker(1001,"JBL","Flip 6",20,true,true,7500,"Black"));
        list.add(new Speaker(1002,"Sony","SRS-XB33",30,true,true,8500,"Blue"));
        list.add(new Speaker(1003,"Bose","SoundLink",25,true,false,12000,"Grey"));
        list.add(new Speaker(1004,"Boat","Stone 200",20,true,false,2500,"Red"));
        list.add(new Speaker(1005,"Marshall","Stockwell II",25,true,false,14500,"Green"));
        list.add(new Speaker(1006,"Samsung","Level Box",30,true,true,6500,"White"));
        list.add(new Speaker(1007,"LG","XBoom Go",20,true,false,4000,"Black"));
        list.add(new Speaker(1008,"Philips","BT6000",15,true,false,3500,"Blue"));
        list.add(new Speaker(1009,"Infinity","One",25,true,true,7000,"Red"));
        list.add(new Speaker(1010,"Sony","XB12",10,true,true,3000,"Grey"));
        list.add(new Speaker(1011,"JBL","Charge 5",30,true,true,9500,"Black"));
        list.add(new Speaker(1012,"Boat","Stone 1400",25,true,false,4500,"Yellow"));
        list.add(new Speaker(1013,"Bose","SoundLink Mini",20,true,false,11000,"White"));
        list.add(new Speaker(1014,"Marshall","Tufton",35,true,false,16000,"Brown"));
        list.add(new Speaker(1015,"LG","PK5",25,true,true,5500,"Silver"));

        return list;
    }
    @Bean("b12")
    public List<SmartWatch> getSmartWatch() {

        List list = new ArrayList();

        list.add(new SmartWatch(1101,"Apple","Series 8",42000,"Silver",true,true,18));
        list.add(new SmartWatch(1102,"Samsung","Galaxy Watch 6",32000,"Black",true,true,24));
        list.add(new SmartWatch(1103,"Fitbit","Versa 4",18000,"Blue",true,true,20));
        list.add(new SmartWatch(1104,"Garmin","Vivoactive 4",25000,"White",true,true,21));
        list.add(new SmartWatch(1105,"Amazfit","GTR 4",14000,"Grey",true,true,24));
        list.add(new SmartWatch(1106,"Noise","ColorFit Ultra",5000,"Red",true,true,10));
        list.add(new SmartWatch(1107,"Fire-Boltt","Phoenix Ultra",4500,"Black",true,true,12));
        list.add(new SmartWatch(1108,"Boat","Watch Wave Call",3000,"Blue",true,true,8));
        list.add(new SmartWatch(1109,"Realme","Watch 3 Pro",6000,"Silver",true,true,14));
        list.add(new SmartWatch(1110,"TicWatch","Pro 3",28000,"Black",true,true,48));
        list.add(new SmartWatch(1111,"Huawei","Watch GT 3",15000,"Brown",true,true,21));
        list.add(new SmartWatch(1112,"OnePlus","Watch 2",12000,"Green",true,true,14));
        list.add(new SmartWatch(1113,"Oppo","Watch 3",16000,"Grey",true,true,15));
        list.add(new SmartWatch(1114,"Samsung","Galaxy Watch 5",30000,"Pink",true,true,24));
        list.add(new SmartWatch(1115,"Apple","SE 2nd Gen",28000,"Black",true,true,18));

        return list;
    }
    @Bean("b13")
    public List<Shoes> getShoes() {

        List list = new ArrayList();

        list.add(new Shoes(1201,"Nike","Sports","Black",9,4500,"Leather","Manoj"));
        list.add(new Shoes(1202,"Adidas","Casual","White",8,4000,"Synthetic","Ravi"));
        list.add(new Shoes(1203,"Puma","Running","Blue",10,3500,"Mesh","Kiran"));
        list.add(new Shoes(1204,"Reebok","Training","Grey",9,3800,"Leather","Arun"));
        list.add(new Shoes(1205,"Skechers","Casual","Black",8,3200,"Synthetic","Vijay"));
        list.add(new Shoes(1206,"Fila","Sports","Red",10,3700,"Leather","Sam"));
        list.add(new Shoes(1207,"Under Armour","Running","White",9,4200,"Mesh","Rohit"));
        list.add(new Shoes(1208,"New Balance","Casual","Blue",8,3600,"Synthetic","Suresh"));
        list.add(new Shoes(1209,"Asics","Sports","Grey",10,3900,"Mesh","Naveen"));
        list.add(new Shoes(1210,"Puma","Training","Black",9,3400,"Leather","Ramesh"));
        list.add(new Shoes(1211,"Nike","Casual","Red",8,4500,"Synthetic","Harsha"));
        list.add(new Shoes(1212,"Adidas","Running","Blue",9,4000,"Mesh","Karthik"));
        list.add(new Shoes(1213,"Reebok","Sports","Grey",10,3800,"Leather","Prasad"));
        list.add(new Shoes(1214,"Skechers","Casual","Black",9,3600,"Synthetic","Shivu"));
        list.add(new Shoes(1215,"Fila","Training","White",8,3700,"Mesh","Yogesh"));

        return list;
    }
    @Bean("b14")
    public List<Router> getRouter() {

        List list = new ArrayList();

        list.add(new Router(1301,"TP-Link","Archer C6",1200,true,2500,4,"Black"));
        list.add(new Router(1302,"Netgear","R6120",1000,false,2000,2,"White"));
        list.add(new Router(1303,"D-Link","DIR-825",1300,true,2700,4,"Grey"));
        list.add(new Router(1304,"Asus","RT-AC66U",1750,true,4500,3,"Black"));
        list.add(new Router(1305,"Linksys","E1200",1000,false,2200,2,"Blue"));
        list.add(new Router(1306,"Tenda","AC10",1200,true,2300,3,"White"));
        list.add(new Router(1307,"Xiaomi","Mi Router 4C",1200,false,1500,4,"White"));
        list.add(new Router(1308,"TP-Link","Archer A7",1750,true,3500,3,"Black"));
        list.add(new Router(1309,"Netgear","Nighthawk R6700",1900,true,5000,4,"Black"));
        list.add(new Router(1310,"D-Link","DIR-615",1000,false,1800,2,"Grey"));
        list.add(new Router(1311,"Asus","RT-AC1200",1200,true,3200,3,"Blue"));
        list.add(new Router(1312,"Linksys","EA6350",1200,true,4000,4,"Black"));
        list.add(new Router(1313,"Tenda","F3",900,false,1500,3,"White"));
        list.add(new Router(1314,"Xiaomi","Mi Router 3",1000,false,1200,3,"Grey"));
        list.add(new Router(1315,"TP-Link","TL-WR840N",750,false,1100,2,"Black"));

        return list;
    }
    @Bean("b15")
    public List<Printer> getPrinter() {

        List list = new ArrayList();

        list.add(new Printer(1401,"HP","DeskJet 2331",true,true,20,4500,"Inkjet"));
        list.add(new Printer(1402,"Canon","Pixma G3010",true,true,15,5200,"Inkjet"));
        list.add(new Printer(1403,"Epson","L3150",true,true,18,4800,"Inkjet"));
        list.add(new Printer(1404,"Brother","HL-L2321D",false,false,30,6000,"Laser"));
        list.add(new Printer(1405,"HP","LaserJet Pro MFP",true,true,25,7500,"Laser"));
        list.add(new Printer(1406,"Canon","LBP6030w",false,true,20,5000,"Laser"));
        list.add(new Printer(1407,"Epson","EcoTank L6160",true,true,22,8000,"Inkjet"));
        list.add(new Printer(1408,"Brother","DCP-T510W",true,true,18,6500,"Inkjet"));
        list.add(new Printer(1409,"Samsung","Xpress SL-M2021",false,false,21,4000,"Laser"));
        list.add(new Printer(1410,"Xerox","Phaser 3260",false,false,24,7200,"Laser"));
        list.add(new Printer(1411,"HP","Envy 6020",true,true,16,4700,"Inkjet"));
        list.add(new Printer(1412,"Canon","i-Sensys LBP6030",false,false,20,4800,"Laser"));
        list.add(new Printer(1413,"Epson","WorkForce WF-2850",true,true,18,5200,"Inkjet"));
        list.add(new Printer(1414,"Brother","HL-L2350DW",false,true,30,5500,"Laser"));
        list.add(new Printer(1415,"HP","OfficeJet Pro 8025",true,true,22,8000,"Inkjet"));

        return list;
    }
    @Bean("b16")
    public List<PowerBank> getPowerBank() {

        List list = new ArrayList();

        list.add(new PowerBank(1501,"Mi",20000,true,"Black",2000,450,"PB-Mi20K"));
        list.add(new PowerBank(1502,"Realme",10000,true,"White",1200,250,"PB-RM10K"));
        list.add(new PowerBank(1503,"Ambrane",15000,false,"Blue",1500,350,"PB-AB15K"));
        list.add(new PowerBank(1504,"Boat",10000,true,"Red",1300,300,"PB-BT10K"));
        list.add(new PowerBank(1505,"Samsung",20000,true,"Grey",2500,500,"PB-SM20K"));
        list.add(new PowerBank(1506,"PTron",10000,false,"Black",1100,250,"PB-PT10K"));
        list.add(new PowerBank(1507,"Noise",15000,true,"White",1600,400,"PB-NS15K"));
        list.add(new PowerBank(1508,"Mi",10000,true,"Blue",1200,250,"PB-Mi10K"));
        list.add(new PowerBank(1509,"Realme",20000,true,"Black",2200,450,"PB-RM20K"));
        list.add(new PowerBank(1510,"Ambrane",10000,false,"Red",1100,300,"PB-AB10K"));
        list.add(new PowerBank(1511,"Boat",20000,true,"Grey",2400,500,"PB-BT20K"));
        list.add(new PowerBank(1512,"Samsung",15000,true,"White",1800,400,"PB-SM15K"));
        list.add(new PowerBank(1513,"PTron",20000,false,"Black",2300,500,"PB-PT20K"));
        list.add(new PowerBank(1514,"Noise",10000,true,"Blue",1300,250,"PB-NS10K"));
        list.add(new PowerBank(1515,"Mi",15000,true,"Red",1700,350,"PB-Mi15K"));

        return list;
    }
    @Bean("b26")
    public List<Pillow> getPillow() {

        List list = new ArrayList();

        list.add(new Pillow(1601,"Cotton","Standard","White",800,true,"Soft","SleepWell"));
        list.add(new Pillow(1602,"Memory Foam","Queen","Grey",1200,true,"Orthopedic","RestEasy"));
        list.add(new Pillow(1603,"Polyester","King","Blue",700,false,"Soft","ComfortPlus"));
        list.add(new Pillow(1604,"Feather","Standard","Beige",1500,true,"Luxury","SleepTight"));
        list.add(new Pillow(1605,"Cotton","Queen","Pink",900,true,"Soft","HomeComfort"));
        list.add(new Pillow(1606,"Memory Foam","Standard","Grey",1300,true,"Orthopedic","CloudNine"));
        list.add(new Pillow(1607,"Polyester","King","White",800,false,"Soft","DreamLand"));
        list.add(new Pillow(1608,"Feather","Queen","Blue",1400,true,"Luxury","SleepWell"));
        list.add(new Pillow(1609,"Cotton","Standard","Grey",850,true,"Soft","RestEasy"));
        list.add(new Pillow(1610,"Memory Foam","King","Beige",1600,true,"Orthopedic","ComfortPlus"));
        list.add(new Pillow(1611,"Polyester","Queen","White",750,false,"Soft","SleepTight"));
        list.add(new Pillow(1612,"Feather","Standard","Blue",1500,true,"Luxury","HomeComfort"));
        list.add(new Pillow(1613,"Cotton","King","Grey",950,true,"Soft","CloudNine"));
        list.add(new Pillow(1614,"Memory Foam","Queen","Pink",1300,true,"Orthopedic","DreamLand"));
        list.add(new Pillow(1615,"Polyester","Standard","Beige",700,false,"Soft","SleepWell"));

        return list;
    }
    @Bean("b17")
    public List<Pen> getPen() {

        List list = new ArrayList();

        list.add(new Pen(1701,"Reynolds","Blue","Ballpoint",50,true,"Plastic","RX101"));
        list.add(new Pen(1702,"Pilot","Black","Gel",100,true,"Plastic","G2"));
        list.add(new Pen(1703,"Parker","Blue","Fountain",1200,true,"Metal","IM"));
        list.add(new Pen(1704,"Cello","Red","Ballpoint",40,true,"Plastic","TriClick"));
        list.add(new Pen(1705,"Luxor","Blue","Gel",80,true,"Plastic","GlideX"));
        list.add(new Pen(1706,"Parker","Black","Fountain",1300,true,"Metal","Jotter"));
        list.add(new Pen(1707,"Reynolds","Green","Ballpoint",50,true,"Plastic","RX202"));
        list.add(new Pen(1708,"Pilot","Red","Gel",90,true,"Plastic","G1"));
        list.add(new Pen(1709,"Cello","Blue","Ballpoint",45,true,"Plastic","TriPoint"));
        list.add(new Pen(1710,"Luxor","Black","Gel",85,true,"Plastic","GlidePro"));
        list.add(new Pen(1711,"Parker","Blue","Fountain",1400,true,"Metal","Sonnet"));
        list.add(new Pen(1712,"Reynolds","Black","Ballpoint",50,true,"Plastic","RX303"));
        list.add(new Pen(1713,"Pilot","Green","Gel",100,true,"Plastic","G3"));
        list.add(new Pen(1714,"Cello","Red","Ballpoint",45,true,"Plastic","TriLine"));
        list.add(new Pen(1715,"Luxor","Blue","Gel",80,true,"Plastic","GlideMax"));

        return list;
    }
    @Bean("b18")
    public List<NoteBook> getNoteBook() {

        List list = new ArrayList();

        list.add(new NoteBook(1801,"Classmate",200,"Blue","A4",150,true,"Plain"));
        list.add(new NoteBook(1802,"Navneet",150,"Red","A5",120,false,"Lines"));
        list.add(new NoteBook(1803,"Camlin",100,"Green","A4",100,true,"Graph"));
        list.add(new NoteBook(1804,"Classmate",250,"Black","A4",180,true,"Plain"));
        list.add(new NoteBook(1805,"Navneet",120,"Yellow","A5",110,false,"Lines"));
        list.add(new NoteBook(1806,"Camlin",300,"Blue","A4",200,true,"Design"));
        list.add(new NoteBook(1807,"Classmate",150,"Pink","A5",130,false,"Plain"));
        list.add(new NoteBook(1808,"Navneet",200,"White","A4",150,true,"Lines"));
        list.add(new NoteBook(1809,"Camlin",100,"Grey","A5",90,false,"Graph"));
        list.add(new NoteBook(1810,"Classmate",220,"Blue","A4",160,true,"Design"));
        list.add(new NoteBook(1811,"Navneet",180,"Red","A5",140,false,"Plain"));
        list.add(new NoteBook(1812,"Camlin",150,"Green","A4",120,true,"Lines"));
        list.add(new NoteBook(1813,"Classmate",200,"Black","A4",150,true,"Graph"));
        list.add(new NoteBook(1814,"Navneet",120,"Blue","A5",110,false,"Design"));
        list.add(new NoteBook(1815,"Camlin",250,"White","A4",180,true,"Plain"));

        return list;
    }
    @Bean("b19")
    public List<Mouse> getMouse() {

        List list = new ArrayList();

        list.add(new Mouse(1901,"Logitech","M235",true,"Black",1200,1000,"Ergonomic"));
        list.add(new Mouse(1902,"HP","X350",false,"White",800,800,"Standard"));
        list.add(new Mouse(1903,"Dell","MS116",true,"Grey",900,1000,"Ergonomic"));
        list.add(new Mouse(1904,"Microsoft","Basic",false,"Black",700,800,"Standard"));
        list.add(new Mouse(1905,"Lenovo","310",true,"Red",950,1200,"Ergonomic"));
        list.add(new Mouse(1906,"Logitech","M221",true,"Blue",1000,1000,"Standard"));
        list.add(new Mouse(1907,"HP","X500",false,"Black",850,800,"Ergonomic"));
        list.add(new Mouse(1908,"Dell","MS111",true,"White",900,1000,"Standard"));
        list.add(new Mouse(1909,"Microsoft","Sculpt",true,"Grey",1300,1200,"Ergonomic"));
        list.add(new Mouse(1910,"Lenovo","M110",false,"Black",750,800,"Standard"));
        list.add(new Mouse(1911,"Logitech","M330",true,"Blue",1100,1000,"Ergonomic"));
        list.add(new Mouse(1912,"HP","X200",false,"Red",800,800,"Standard"));
        list.add(new Mouse(1913,"Dell","MS113",true,"Black",950,1200,"Ergonomic"));
        list.add(new Mouse(1914,"Microsoft","Mobile",true,"White",1000,1000,"Standard"));
        list.add(new Mouse(1915,"Lenovo","M120",false,"Grey",850,800,"Ergonomic"));

        return list;
    }
    @Bean("b20")
    public List<Mirror> getMirror() {
        List list = new ArrayList<>();
        list.add(new Mirror(2001,"Round","Wood","Brown",40,40,1200,"HomeDeco"));
        list.add(new Mirror(2002,"Oval","Metal","Silver",50,30,1500,"StyleMart"));
        list.add(new Mirror(2003,"Square","Plastic","White",45,45,1000,"DecorPlus"));
        list.add(new Mirror(2004,"Rectangle","Wood","Black",60,40,2000,"MirrorArt"));
        list.add(new Mirror(2005,"Round","Metal","Gold",50,50,1800,"HomeDeco"));
        list.add(new Mirror(2006,"Oval","Plastic","Blue",40,30,900,"StyleMart"));
        list.add(new Mirror(2007,"Square","Wood","Brown",55,55,1300,"DecorPlus"));
        list.add(new Mirror(2008,"Rectangle","Metal","Black",60,50,2200,"MirrorArt"));
        list.add(new Mirror(2009,"Round","Plastic","Grey",45,45,1100,"HomeDeco"));
        list.add(new Mirror(2010,"Oval","Wood","White",50,35,1400,"StyleMart"));
        list.add(new Mirror(2011,"Square","Metal","Silver",50,50,1600,"DecorPlus"));
        list.add(new Mirror(2012,"Rectangle","Plastic","Black",55,45,1900,"MirrorArt"));
        list.add(new Mirror(2013,"Round","Wood","Brown",40,40,1200,"HomeDeco"));
        list.add(new Mirror(2014,"Oval","Metal","Gold",50,30,1700,"StyleMart"));
        list.add(new Mirror(2015,"Square","Plastic","Blue",45,45,1000,"DecorPlus"));
        return list;
    }

    @Bean("b21")
    public List<MicrowaveOven> getMicrowave() {
        List list = new ArrayList<>();
        list.add(new MicrowaveOven(2101,"Samsung",20,700,"Silver",true,8000,"MW1"));
        list.add(new MicrowaveOven(2102,"LG",25,800,"Black",false,9000,"MW2"));
        list.add(new MicrowaveOven(2103,"IFB",20,750,"White",true,8500,"MW3"));
        list.add(new MicrowaveOven(2104,"Panasonic",23,700,"Grey",false,9500,"MW4"));
        list.add(new MicrowaveOven(2105,"Whirlpool",25,900,"Silver",true,10000,"MW5"));
        list.add(new MicrowaveOven(2106,"Bajaj",18,600,"White",false,7500,"MW6"));
        list.add(new MicrowaveOven(2107,"Samsung",20,700,"Black",true,8200,"MW7"));
        list.add(new MicrowaveOven(2108,"LG",22,800,"Silver",false,8800,"MW8"));
        list.add(new MicrowaveOven(2109,"IFB",25,900,"White",true,9700,"MW9"));
        list.add(new MicrowaveOven(2110,"Panasonic",20,700,"Grey",false,9100,"MW10"));
        list.add(new MicrowaveOven(2111,"Whirlpool",23,750,"Silver",true,9800,"MW11"));
        list.add(new MicrowaveOven(2112,"Bajaj",18,600,"Black",false,7600,"MW12"));
        list.add(new MicrowaveOven(2113,"Samsung",20,700,"White",true,8200,"MW13"));
        list.add(new MicrowaveOven(2114,"LG",25,800,"Grey",false,9000,"MW14"));
        list.add(new MicrowaveOven(2115,"IFB",22,750,"Silver",true,9500,"MW15"));
        return list;
    }

    @Bean("b22")
    public List<KeyBoard> getKeyBoard() {
        List list = new ArrayList<>();
        list.add(new KeyBoard(2201,"Logitech","Mechanical",true,"Black",2500,"QWERTY","K100"));
        list.add(new KeyBoard(2202,"HP","Membrane",false,"White",1500,"QWERTY","K101"));
        list.add(new KeyBoard(2203,"Dell","Mechanical",true,"Grey",2700,"QWERTY","K102"));
        list.add(new KeyBoard(2204,"Lenovo","Membrane",false,"Black",1800,"QWERTY","K103"));
        list.add(new KeyBoard(2205,"Asus","Mechanical",true,"Red",3000,"QWERTY","K104"));
        list.add(new KeyBoard(2206,"Logitech","Membrane",false,"Blue",2000,"QWERTY","K105"));
        list.add(new KeyBoard(2207,"HP","Mechanical",true,"Black",2600,"QWERTY","K106"));
        list.add(new KeyBoard(2208,"Dell","Membrane",false,"Grey",1700,"QWERTY","K107"));
        list.add(new KeyBoard(2209,"Lenovo","Mechanical",true,"White",2800,"QWERTY","K108"));
        list.add(new KeyBoard(2210,"Asus","Membrane",false,"Black",1900,"QWERTY","K109"));
        list.add(new KeyBoard(2211,"Logitech","Mechanical",true,"Red",2500,"QWERTY","K110"));
        list.add(new KeyBoard(2212,"HP","Membrane",false,"Blue",1600,"QWERTY","K111"));
        list.add(new KeyBoard(2213,"Dell","Mechanical",true,"Black",2700,"QWERTY","K112"));
        list.add(new KeyBoard(2214,"Lenovo","Membrane",false,"White",1800,"QWERTY","K113"));
        list.add(new KeyBoard(2215,"Asus","Mechanical",true,"Grey",3000,"QWERTY","K114"));
        return list;
    }

    @Bean("b23")
    public List<HelmateCover> getHelmateCover() {
        List list = new ArrayList<>();
        list.add(new HelmateCover(2301,"Steelbird","Black","Plastic",1200,true,"M","HC101"));
        list.add(new HelmateCover(2302,"Vega","Red","Polycarbonate",1300,false,"L","HC102"));
        list.add(new HelmateCover(2303,"Studds","Blue","Plastic",1100,true,"S","HC103"));
        list.add(new HelmateCover(2304,"Steelbird","White","Plastic",1400,false,"XL","HC104"));
        list.add(new HelmateCover(2305,"Vega","Black","Polycarbonate",1250,true,"M","HC105"));
        list.add(new HelmateCover(2306,"Studds","Grey","Plastic",1150,false,"L","HC106"));
        list.add(new HelmateCover(2307,"Steelbird","Red","Plastic",1300,true,"S","HC107"));
        list.add(new HelmateCover(2308,"Vega","Blue","Polycarbonate",1200,false,"XL","HC108"));
        list.add(new HelmateCover(2309,"Studds","Black","Plastic",1400,true,"M","HC109"));
        list.add(new HelmateCover(2310,"Steelbird","Grey","Plastic",1250,false,"L","HC110"));
        list.add(new HelmateCover(2311,"Vega","White","Polycarbonate",1300,true,"S","HC111"));
        list.add(new HelmateCover(2312,"Studds","Blue","Plastic",1150,false,"XL","HC112"));
        list.add(new HelmateCover(2313,"Steelbird","Black","Plastic",1200,true,"M","HC113"));
        list.add(new HelmateCover(2314,"Vega","Red","Polycarbonate",1300,false,"L","HC114"));
        list.add(new HelmateCover(2315,"Studds","White","Plastic",1100,true,"S","HC115"));
        return list;
    }

    @Bean("b24")
    public List<Helmate> getHelmate() {
        List list = new ArrayList<>();
        list.add(new Helmate(2401,"Steelbird","SB101","Black",true,3500,"Plastic","M"));
        list.add(new Helmate(2402,"Vega","VG102","Red",false,3000,"Polycarbonate","L"));
        list.add(new Helmate(2403,"Studds","SD103","Blue",true,3200,"Plastic","S"));
        list.add(new Helmate(2404,"Steelbird","SB104","White",false,4000,"Plastic","XL"));
        list.add(new Helmate(2405,"Vega","VG105","Black",true,3600,"Polycarbonate","M"));
        list.add(new Helmate(2406,"Studds","SD106","Grey",false,3100,"Plastic","L"));
        list.add(new Helmate(2407,"Steelbird","SB107","Red",true,3300,"Plastic","S"));
        list.add(new Helmate(2408,"Vega","VG108","Blue",false,3500,"Polycarbonate","XL"));
        list.add(new Helmate(2409,"Studds","SD109","Black",true,3700,"Plastic","M"));
        list.add(new Helmate(2410,"Steelbird","SB110","Grey",false,3200,"Plastic","L"));
        list.add(new Helmate(2411,"Vega","VG111","White",true,3400,"Polycarbonate","S"));
        list.add(new Helmate(2412,"Studds","SD112","Blue",false,3100,"Plastic","XL"));
        list.add(new Helmate(2413,"Steelbird","SB113","Black",true,3500,"Plastic","M"));
        list.add(new Helmate(2414,"Vega","VG114","Red",false,3600,"Polycarbonate","L"));
        list.add(new Helmate(2415,"Studds","SD115","White",true,3300,"Plastic","S"));
        return list;
    }

    @Bean("b25")
    public List<Headphone> getHeadphone() {
        List list = new ArrayList<>();
        list.add(new Headphone(2501,"Sony","WH-1000XM5",true,30,"Black",25000,true));
        list.add(new Headphone(2502,"Bose","QC35 II",true,20,"Silver",22000,true));
        list.add(new Headphone(2503,"Boat","Rockerz 510",true,10,"Red",3500,false));
        list.add(new Headphone(2504,"JBL","Tune 750BT",true,12,"Blue",5000,true));
        list.add(new Headphone(2505,"Sennheiser","HD 450BT",true,25,"Black",15000,true));
        list.add(new Headphone(2506,"Sony","MDR-ZX110",false,8,"Grey",2000,false));
        list.add(new Headphone(2507,"Bose","700",true,20,"White",24000,true));
        list.add(new Headphone(2508,"Boat","Rockerz 600",true,15,"Black",4000,false));
        list.add(new Headphone(2509,"JBL","Live 400BT",true,18,"Blue",6000,true));
        list.add(new Headphone(2510,"Sennheiser","HD 350BT",true,20,"Grey",13000,true));
        list.add(new Headphone(2511,"Sony","WH-CH510",true,15,"Black",5000,false));
        list.add(new Headphone(2512,"Bose","SoundLink",true,25,"Silver",20000,true));
        list.add(new Headphone(2513,"Boat","Rockerz 400",true,12,"Red",3500,false));
        list.add(new Headphone(2514,"JBL","Tune 500BT",true,15,"Black",4000,true));
        list.add(new Headphone(2515,"Sennheiser","HD 450",true,20,"Blue",14000,true));
        return list;
    }

}
