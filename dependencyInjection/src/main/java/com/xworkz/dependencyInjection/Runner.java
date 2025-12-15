package com.xworkz.dependencyInjection;

import com.xworkz.dependencyInjection.components.airport.Airport;
import com.xworkz.dependencyInjection.components.airport.Terminal;
import com.xworkz.dependencyInjection.components.backery.Backery;
import com.xworkz.dependencyInjection.components.backery.Oven;
import com.xworkz.dependencyInjection.components.bank.Account;
import com.xworkz.dependencyInjection.components.bank.Bank;
import com.xworkz.dependencyInjection.components.bike.Bike;
import com.xworkz.dependencyInjection.components.bike.Helmate;
import com.xworkz.dependencyInjection.components.bus.Bus;
import com.xworkz.dependencyInjection.components.bus.Driver;
import com.xworkz.dependencyInjection.components.camera.Camera;
import com.xworkz.dependencyInjection.components.camera.Lens;
import com.xworkz.dependencyInjection.components.capital.Capital;
import com.xworkz.dependencyInjection.components.capital.Country;
import com.xworkz.dependencyInjection.components.car.Car;
import com.xworkz.dependencyInjection.components.car.Wheel;
import com.xworkz.dependencyInjection.components.church.Church;
import com.xworkz.dependencyInjection.components.church.Pastor;
import com.xworkz.dependencyInjection.components.cinema.Cinema;
import com.xworkz.dependencyInjection.components.cinema.Screen;
import com.xworkz.dependencyInjection.components.city.City;
import com.xworkz.dependencyInjection.components.city.Road;
import com.xworkz.dependencyInjection.components.cloud.Cloud;
import com.xworkz.dependencyInjection.components.cloud.Server;
import com.xworkz.dependencyInjection.components.college.College;
import com.xworkz.dependencyInjection.components.college.Department;
import com.xworkz.dependencyInjection.components.company.Company;
import com.xworkz.dependencyInjection.components.company.Employee;
import com.xworkz.dependencyInjection.components.court.Court;
import com.xworkz.dependencyInjection.components.court.Judge;
import com.xworkz.dependencyInjection.components.dam.Dam;
import com.xworkz.dependencyInjection.components.dam.Gate;
import com.xworkz.dependencyInjection.components.dataCenter.DataCenter;
import com.xworkz.dependencyInjection.components.dataCenter.Storage;
import com.xworkz.dependencyInjection.components.drama.Actor;
import com.xworkz.dependencyInjection.components.drama.Drama;
import com.xworkz.dependencyInjection.components.event.Event;
import com.xworkz.dependencyInjection.components.event.Organizer;
import com.xworkz.dependencyInjection.components.factory.Factory;
import com.xworkz.dependencyInjection.components.factory.Machine;
import com.xworkz.dependencyInjection.components.farm.Crop;
import com.xworkz.dependencyInjection.components.farm.Farm;
import com.xworkz.dependencyInjection.components.fireStation.FireMan;
import com.xworkz.dependencyInjection.components.fireStation.FireStation;
import com.xworkz.dependencyInjection.components.forest.Forest;
import com.xworkz.dependencyInjection.components.forest.Tree;
import com.xworkz.dependencyInjection.components.game.Game;
import com.xworkz.dependencyInjection.components.game.Level;
import com.xworkz.dependencyInjection.components.garage.Garage;
import com.xworkz.dependencyInjection.components.garage.Mechanic;
import com.xworkz.dependencyInjection.components.hostel.Hostel;
import com.xworkz.dependencyInjection.components.hostel.Warden;
import com.xworkz.dependencyInjection.components.hotel.Hotel;
import com.xworkz.dependencyInjection.components.hotel.Room;
import com.xworkz.dependencyInjection.components.house.Door;
import com.xworkz.dependencyInjection.components.house.House;
import com.xworkz.dependencyInjection.components.laptop.Laptop;
import com.xworkz.dependencyInjection.components.laptop.Processor;
import com.xworkz.dependencyInjection.components.library.Book;
import com.xworkz.dependencyInjection.components.library.Library;
import com.xworkz.dependencyInjection.components.mall.Mall;
import com.xworkz.dependencyInjection.components.mall.Shop;
import com.xworkz.dependencyInjection.components.market.Market;
import com.xworkz.dependencyInjection.components.market.Vendor;
import com.xworkz.dependencyInjection.components.mobileApp.Feature;
import com.xworkz.dependencyInjection.components.mobileApp.MobileApp;
import com.xworkz.dependencyInjection.components.movie.Hero;
import com.xworkz.dependencyInjection.components.movie.Movie;
import com.xworkz.dependencyInjection.components.museum.Item;
import com.xworkz.dependencyInjection.components.museum.Museum;
import com.xworkz.dependencyInjection.components.music.Music;
import com.xworkz.dependencyInjection.components.music.Singer;
import com.xworkz.dependencyInjection.components.newspaper.Newspaper;
import com.xworkz.dependencyInjection.components.newspaper.Writer;
import com.xworkz.dependencyInjection.components.orchestra.Conductor;
import com.xworkz.dependencyInjection.components.orchestra.Orchestra;
import com.xworkz.dependencyInjection.components.phone.Battery;
import com.xworkz.dependencyInjection.components.phone.Phone;
import com.xworkz.dependencyInjection.components.policeStation.Inspector;
import com.xworkz.dependencyInjection.components.policeStation.PoliceStation;
import com.xworkz.dependencyInjection.components.powerPlant.PowerPlant;
import com.xworkz.dependencyInjection.components.powerPlant.Turbine;
import com.xworkz.dependencyInjection.components.radioStation.RadioChannel;
import com.xworkz.dependencyInjection.components.radioStation.RadioStation;
import com.xworkz.dependencyInjection.components.restorant.Kitchen;
import com.xworkz.dependencyInjection.components.restorant.Restorant;
import com.xworkz.dependencyInjection.components.rocket.Rocket;
import com.xworkz.dependencyInjection.components.rocket.RocketEngine;
import com.xworkz.dependencyInjection.components.school.ClassRoom;
import com.xworkz.dependencyInjection.components.school.School;
import com.xworkz.dependencyInjection.components.ship.Captain;
import com.xworkz.dependencyInjection.components.ship.Ship;
import com.xworkz.dependencyInjection.components.shirt.Shirt;
import com.xworkz.dependencyInjection.components.shirt.Size;
import com.xworkz.dependencyInjection.components.shopMall.Counter;
import com.xworkz.dependencyInjection.components.shopMall.ShopMall;
import com.xworkz.dependencyInjection.components.softwareCompany.Developer;
import com.xworkz.dependencyInjection.components.softwareCompany.SoftwareCompany;
import com.xworkz.dependencyInjection.components.stadium.Ground;
import com.xworkz.dependencyInjection.components.stadium.Stadium;
import com.xworkz.dependencyInjection.components.state.District;
import com.xworkz.dependencyInjection.components.state.State;
import com.xworkz.dependencyInjection.components.temple.God;
import com.xworkz.dependencyInjection.components.temple.Temple;
import com.xworkz.dependencyInjection.components.train.Engine;
import com.xworkz.dependencyInjection.components.train.Train;
import com.xworkz.dependencyInjection.components.tvChannel.Anchor;
import com.xworkz.dependencyInjection.components.tvChannel.TVChannel;
import com.xworkz.dependencyInjection.components.university.Faculty;
import com.xworkz.dependencyInjection.components.university.University;
import com.xworkz.dependencyInjection.components.website.Page;
import com.xworkz.dependencyInjection.components.website.Website;
import com.xworkz.dependencyInjection.components.zoo.Animal;
import com.xworkz.dependencyInjection.components.zoo.Zoo;
import com.xworkz.dependencyInjection.configure.Configure;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Configure.class);

        Shirt shirt = applicationContext.getBean(Shirt.class);
        System.out.println(shirt);

        Shirt shirt1 = applicationContext.getBean(Shirt.class);
        System.out.println(shirt1);

        Size size = shirt.getSize();
        System.out.println(size);

        Size size1 = shirt1.getSize();
        System.out.println(size1);

        System.out.println("---------------------------------------------------");


        Airport airport = applicationContext.getBean(Airport.class);
        System.out.println(airport);

        Airport airport1 = applicationContext.getBean(Airport.class);
        System.out.println(airport1);

        Terminal terminal = airport.getTerminal();
        System.out.println(terminal);

        Terminal terminal1 = airport1.getTerminal();
        System.out.println(terminal1);

        System.out.println("---------------------------------------------------");


        Website website = applicationContext.getBean(Website.class);
        System.out.println(website);

        Website website1 = applicationContext.getBean(Website.class);
        System.out.println(website1);

        Page page = website.getPage();
        System.out.println(page);

        Page page1 = website1.getPage();
        System.out.println(page1);

        System.out.println("---------------------------------------------------");


        University university = applicationContext.getBean(University.class);
        System.out.println(university);

        University university1 = applicationContext.getBean(University.class);
        System.out.println(university1);

        Faculty faculty = university.getFaculty();
        System.out.println(faculty);

        Faculty faculty1 = university1.getFaculty();
        System.out.println(faculty1);

        System.out.println("---------------------------------------------------");


        TVChannel tvChannel = applicationContext.getBean(TVChannel.class);
        System.out.println(tvChannel);

        TVChannel tvChannel1 = applicationContext.getBean(TVChannel.class);
        System.out.println(tvChannel1);

        Anchor anchor = tvChannel.getAnchor();
        System.out.println(anchor);

        Anchor anchor1 = tvChannel1.getAnchor();
        System.out.println(anchor1);

        System.out.println("---------------------------------------------------");


        Train train = applicationContext.getBean(Train.class);
        System.out.println(train);

        Train train1 = applicationContext.getBean(Train.class);
        System.out.println(train1);

        Engine engine = train.getEngine();
        System.out.println(engine);

        Engine engine1 = train1.getEngine();
        System.out.println(engine1);

        System.out.println("---------------------------------------------------");


        Temple temple = applicationContext.getBean(Temple.class);
        System.out.println(temple);

        Temple temple1 = applicationContext.getBean(Temple.class);
        System.out.println(temple1);

        God god = temple.getGod();
        System.out.println(god);

        God god1 = temple1.getGod();
        System.out.println(god1);

        System.out.println("---------------------------------------------------");


        State state = applicationContext.getBean(State.class);
        System.out.println(state);

        State state1 = applicationContext.getBean(State.class);
        System.out.println(state1);

        District district = state.getDistrict();
        System.out.println(district);

        District district1 = state1.getDistrict();
        System.out.println(district1);

        System.out.println("---------------------------------------------------");


        Stadium stadium = applicationContext.getBean(Stadium.class);
        System.out.println(stadium);

        Stadium stadium1 = applicationContext.getBean(Stadium.class);
        System.out.println(stadium1);

        Ground ground = stadium.getGround();
        System.out.println(ground);

        Ground ground1 = stadium1.getGround();
        System.out.println(ground1);

        System.out.println("---------------------------------------------------");


        SoftwareCompany softwareCompany = applicationContext.getBean(SoftwareCompany.class);
        System.out.println(softwareCompany);

        SoftwareCompany softwareCompany1 = applicationContext.getBean(SoftwareCompany.class);
        System.out.println(softwareCompany1);

        Developer developer = softwareCompany.getDeveloper();
        System.out.println(developer);

        Developer developer1 = softwareCompany.getDeveloper();
        System.out.println(developer1);

        System.out.println("---------------------------------------------------");


        ShopMall shopMall = applicationContext.getBean(ShopMall.class);
        System.out.println(shopMall);

        ShopMall shopMall1 = applicationContext.getBean(ShopMall.class);
        System.out.println(shopMall1);

        Counter counter = shopMall.getCounter();
        System.out.println(counter);

        Counter counter1 = shopMall1.getCounter();
        System.out.println(counter1);

        System.out.println("---------------------------------------------------");


        Ship ship = applicationContext.getBean(Ship.class);
        System.out.println(ship);

        Ship ship1 = applicationContext.getBean(Ship.class);
        System.out.println(ship1);

        Captain captain = ship.getCaptain();
        System.out.println(captain);

        Captain captain1 = ship1.getCaptain();
        System.out.println(captain1);

        System.out.println("---------------------------------------------------");


        Zoo zoo = applicationContext.getBean(Zoo.class);
        System.out.println(zoo);

        Zoo zoo1 = applicationContext.getBean(Zoo.class);
        System.out.println(zoo1);

        Animal animal = zoo.getAnimal();
        System.out.println(animal);

        Animal animal1 = zoo1.getAnimal();
        System.out.println(animal1);

        System.out.println("---------------------------------------------------");


        School school = applicationContext.getBean(School.class);
        System.out.println(school);

        School school1 = applicationContext.getBean(School.class);
        System.out.println(school1);

        ClassRoom classroom = school.getClassRoom();
        System.out.println(classroom);

        ClassRoom classroom1 = school1.getClassRoom();
        System.out.println(classroom1);

        System.out.println("---------------------------------------------------");


        Rocket rocket = applicationContext.getBean(Rocket.class);
        System.out.println(rocket);

        Rocket rocket1 = applicationContext.getBean(Rocket.class);
        System.out.println(rocket1);

        RocketEngine eng = rocket.getRocketEngine();
        System.out.println(eng);

        RocketEngine eng1 = rocket1.getRocketEngine();
        System.out.println(eng1);

        System.out.println("---------------------------------------------------");


        Restorant restaurant = applicationContext.getBean(Restorant.class);
        System.out.println(restaurant);

        Restorant restaurant1 = applicationContext.getBean(Restorant.class);
        System.out.println(restaurant1);

        Kitchen kitchen = restaurant.getKitchen();
        System.out.println(kitchen);

        Kitchen kitchen1 = restaurant1.getKitchen();
        System.out.println(kitchen1);

        System.out.println("---------------------------------------------------");


        RadioStation radioStation = applicationContext.getBean(RadioStation.class);
        System.out.println(radioStation);

        RadioStation radioStation1 = applicationContext.getBean(RadioStation.class);
        System.out.println(radioStation1);

        RadioChannel radioChannel = radioStation.getRadioChannel();
        System.out.println(radioChannel);

        RadioChannel radioChannel1 = radioStation1.getRadioChannel();
        System.out.println(radioChannel1);

        System.out.println("---------------------------------------------------");


        PowerPlant powerPlant = applicationContext.getBean(PowerPlant.class);
        System.out.println(powerPlant);

        PowerPlant powerPlant1 = applicationContext.getBean(PowerPlant.class);
        System.out.println(powerPlant1);

        Turbine turbine = powerPlant.getTurbine();
        System.out.println(turbine);

        Turbine turbine1 = powerPlant1.getTurbine();
        System.out.println(turbine1);

        System.out.println("---------------------------------------------------");


        PoliceStation policeStation = applicationContext.getBean(PoliceStation.class);
        System.out.println(policeStation);

        PoliceStation policeStation1 = applicationContext.getBean(PoliceStation.class);
        System.out.println(policeStation1);

        Inspector inspector = policeStation.getInspector();
        System.out.println(inspector);

        Inspector inspector1 = policeStation1.getInspector();
        System.out.println(inspector1);

        System.out.println("---------------------------------------------------");


        Phone phone = applicationContext.getBean(Phone.class);
        System.out.println(phone);

        Phone phone1 = applicationContext.getBean(Phone.class);
        System.out.println(phone1);

        Battery battery = phone.getBattery();
        System.out.println(battery);

        Battery battery1 = phone1.getBattery();
        System.out.println(battery1);

        System.out.println("---------------------------------------------------");


        Orchestra orchestra = applicationContext.getBean(Orchestra.class);
        System.out.println(orchestra);

        Orchestra orchestra1 = applicationContext.getBean(Orchestra.class);
        System.out.println(orchestra1);

        Conductor conductor = orchestra.getConductor();
        System.out.println(conductor);

        Conductor conductor1 = orchestra1.getConductor();
        System.out.println(conductor1);

        System.out.println("---------------------------------------------------");


        Newspaper newspaper = applicationContext.getBean(Newspaper.class);
        System.out.println(newspaper);

        Newspaper newspaper1 = applicationContext.getBean(Newspaper.class);
        System.out.println(newspaper1);

        Writer writer = newspaper.getWrite();
        System.out.println(writer);

        Writer writer1 = newspaper1.getWrite();
        System.out.println(writer1);

        System.out.println("---------------------------------------------------");


        Music music = applicationContext.getBean(Music.class);
        System.out.println(music);

        Music music1 = applicationContext.getBean(Music.class);
        System.out.println(music1);

        Singer singer = music.getSinger();
        System.out.println(singer);

        Singer singer1 = music1.getSinger();
        System.out.println(singer1);

        System.out.println("---------------------------------------------------");


        Museum museum = applicationContext.getBean(Museum.class);
        System.out.println(museum);

        Museum museum1 = applicationContext.getBean(Museum.class);
        System.out.println(museum1);

        Item item = museum.getItem();
        System.out.println(item);

        Item item1 = museum1.getItem();
        System.out.println(item1);

        System.out.println("---------------------------------------------------");


        Movie movie = applicationContext.getBean(Movie.class);
        System.out.println(movie);

        Movie movie1 = applicationContext.getBean(Movie.class);
        System.out.println(movie1);

        Hero hero = movie.getHero();
        System.out.println(hero);

        Hero hero1 = movie1.getHero();
        System.out.println(hero1);

        System.out.println("---------------------------------------------------");


        MobileApp mobileApp = applicationContext.getBean(MobileApp.class);
        System.out.println(mobileApp);

        MobileApp mobileApp1 = applicationContext.getBean(MobileApp.class);
        System.out.println(mobileApp1);

        Feature feature = mobileApp.getFeature();
        System.out.println(feature);

        Feature feature1 = mobileApp1.getFeature();
        System.out.println(feature1);

        System.out.println("---------------------------------------------------");


        Market market = applicationContext.getBean(Market.class);
        System.out.println(market);

        Market market1 = applicationContext.getBean(Market.class);
        System.out.println(market1);

        Vendor vendor = market.getVendor();
        System.out.println(vendor);

        Vendor vendor1 = market1.getVendor();
        System.out.println(vendor1);

        System.out.println("---------------------------------------------------");


        Mall mall = applicationContext.getBean(Mall.class);
        System.out.println(mall);

        Mall mall1 = applicationContext.getBean(Mall.class);
        System.out.println(mall1);

        Shop shop = mall.getShop();
        System.out.println(shop);

        Shop shop1 = mall1.getShop();
        System.out.println(shop1);

        System.out.println("---------------------------------------------------");


        Library library = applicationContext.getBean(Library.class);
        System.out.println(library);

        Library library1 = applicationContext.getBean(Library.class);
        System.out.println(library1);

        Book book = library.getBook();
        System.out.println(book);

        Book book1 = library1.getBook();
        System.out.println(book1);

        System.out.println("---------------------------------------------------");


        Laptop laptop = applicationContext.getBean(Laptop.class);
        System.out.println(laptop);

        Laptop laptop1 = applicationContext.getBean(Laptop.class);
        System.out.println(laptop1);

        Processor processor = laptop.getProcessor();
        System.out.println(processor);

        Processor processor1 = laptop1.getProcessor();
        System.out.println(processor1);

        System.out.println("---------------------------------------------------");


        House house = applicationContext.getBean(House.class);
        System.out.println(house);

        House house1 = applicationContext.getBean(House.class);
        System.out.println(house1);

        Door door = house.getDoor();
        System.out.println(door);

        Door door1 = house1.getDoor();
        System.out.println(door1);

        System.out.println("---------------------------------------------------");


        Hotel hotel = applicationContext.getBean(Hotel.class);
        System.out.println(hotel);

        Hotel hotel1 = applicationContext.getBean(Hotel.class);
        System.out.println(hotel1);

        Room room = hotel.getRoom();
        System.out.println(room);

        Room room1 = hotel1.getRoom();
        System.out.println(room1);

        System.out.println("---------------------------------------------------");


        Hostel hostel = applicationContext.getBean(Hostel.class);
        System.out.println(hostel);

        Hostel hostel1 = applicationContext.getBean(Hostel.class);
        System.out.println(hostel1);

        Warden warden = hostel.getWarden();
        System.out.println(warden);

        Warden warden1 = hostel1.getWarden();
        System.out.println(warden1);

        System.out.println("---------------------------------------------------");


        Garage garage = applicationContext.getBean(Garage.class);
        System.out.println(garage);

        Garage garage1 = applicationContext.getBean(Garage.class);
        System.out.println(garage1);

        Mechanic mechanic = garage.getMechanic();
        System.out.println(mechanic);

        Mechanic mechanic1 = garage1.getMechanic();
        System.out.println(mechanic1);

        System.out.println("---------------------------------------------------");


        Game game = applicationContext.getBean(Game.class);
        System.out.println(game);

        Game game1 = applicationContext.getBean(Game.class);
        System.out.println(game1);

        Level level = game.getLevel();
        System.out.println(level);

        Level level1 = game1.getLevel();
        System.out.println(level1);

        System.out.println("---------------------------------------------------");


        Forest forest = applicationContext.getBean(Forest.class);
        System.out.println(forest);

        Forest forest1 = applicationContext.getBean(Forest.class);
        System.out.println(forest1);

        Tree tree = forest.getTree();
        System.out.println(tree);

        Tree tree1 = forest1.getTree();
        System.out.println(tree1);

        System.out.println("---------------------------------------------------");


        FireStation fireStation = applicationContext.getBean(FireStation.class);
        System.out.println(fireStation);

        FireStation fireStation1 = applicationContext.getBean(FireStation.class);
        System.out.println(fireStation1);

        FireMan fireman = fireStation.getFireMan();
        System.out.println(fireman);

        FireMan fireman1 = fireStation1.getFireMan();
        System.out.println(fireman1);

        System.out.println("---------------------------------------------------");


        Farm farm = applicationContext.getBean(Farm.class);
        System.out.println(farm);

        Farm farm1 = applicationContext.getBean(Farm.class);
        System.out.println(farm1);

        Crop crop = farm.getCrop();
        System.out.println(crop);

        Crop crop1 = farm1.getCrop();
        System.out.println(crop1);

        System.out.println("---------------------------------------------------");


        Factory factory = applicationContext.getBean(Factory.class);
        System.out.println(factory);

        Factory factory1 = applicationContext.getBean(Factory.class);
        System.out.println(factory1);

        Machine machine = factory.getMachine();
        System.out.println(machine);

        Machine machine1 = factory1.getMachine();
        System.out.println(machine1);

        System.out.println("---------------------------------------------------");


        Event event = applicationContext.getBean(Event.class);
        System.out.println(event);

        Event event1 = applicationContext.getBean(Event.class);
        System.out.println(event1);

        Organizer organizer = event.getOrganizer();
        System.out.println(organizer);

        Organizer organizer1 = event1.getOrganizer();
        System.out.println(organizer1);

        System.out.println("---------------------------------------------------");


        Drama drama = applicationContext.getBean(Drama.class);
        System.out.println(drama);

        Drama drama1 = applicationContext.getBean(Drama.class);
        System.out.println(drama1);

        Actor actor = drama.getActor();
        System.out.println(actor);

        Actor actor1 = drama1.getActor();
        System.out.println(actor1);

        System.out.println("---------------------------------------------------");

        DataCenter dataCenter = applicationContext.getBean(DataCenter.class);
        System.out.println(dataCenter);

        DataCenter dataCenter1 = applicationContext.getBean(DataCenter.class);
        System.out.println(dataCenter1);

        Storage storage = dataCenter.getStorage();
        System.out.println(storage);

        Storage storage1 = dataCenter1.getStorage();
        System.out.println(storage1);

        System.out.println("---------------------------------------------------");

        Dam dam = applicationContext.getBean(Dam.class);
        System.out.println(dam);

        Dam dam1 = applicationContext.getBean(Dam.class);
        System.out.println(dam1);

        Gate gate = dam.getGate();
        System.out.println(gate);

        Gate gate1 = dam1.getGate();
        System.out.println(gate1);

        System.out.println("---------------------------------------------------");

        Court court = applicationContext.getBean(Court.class);
        System.out.println(court);

        Court court1 = applicationContext.getBean(Court.class);
        System.out.println(court1);

        Judge judge = court.getJudge();
        System.out.println(judge);

        Judge judge1 = court1.getJudge();
        System.out.println(judge1);

        System.out.println("---------------------------------------------------");

        Country country = applicationContext.getBean(Country.class);
        System.out.println(country);

        Country country1 = applicationContext.getBean(Country.class);
        System.out.println(country1);

        Capital capital = country.getCapital();
        System.out.println(capital);

        Capital capital1 = country1.getCapital();
        System.out.println(capital1);

        System.out.println("---------------------------------------------------");

        Company company = applicationContext.getBean(Company.class);
        System.out.println(company);

        Company company1 = applicationContext.getBean(Company.class);
        System.out.println(company1);

        Employee employee = company.getEmployee();
        System.out.println(employee);

        Employee employee1 = company1.getEmployee();
        System.out.println(employee1);

        System.out.println("---------------------------------------------------");


        College college = applicationContext.getBean(College.class);
        System.out.println(college);

        College college1 = applicationContext.getBean(College.class);
        System.out.println(college1);

        Department department = college.getDepartment();
        System.out.println(department);

        Department department1 = college1.getDepartment();
        System.out.println(department1);

        System.out.println("---------------------------------------------------");


        Cloud cloud = applicationContext.getBean(Cloud.class);
        System.out.println(cloud);

        Cloud cloud1 = applicationContext.getBean(Cloud.class);
        System.out.println(cloud1);

        Server server = cloud.getServer();
        System.out.println(server);

        Server server1 = cloud1.getServer();
        System.out.println(server1);

        System.out.println("---------------------------------------------------");

        City city = applicationContext.getBean(City.class);
        System.out.println(city);

        City city1 = applicationContext.getBean(City.class);
        System.out.println(city1);

        Road road = city.getRoad();
        System.out.println(road);

        Road road1 = city1.getRoad();
        System.out.println(road1);

        System.out.println("---------------------------------------------------");

        Cinema cinema = applicationContext.getBean(Cinema.class);
        System.out.println(cinema);

        Cinema cinema1 = applicationContext.getBean(Cinema.class);
        System.out.println(cinema1);

        Screen screen = cinema.getScreen();
        System.out.println(screen);

        Screen screen1 = cinema1.getScreen();
        System.out.println(screen1);

        System.out.println("---------------------------------------------------");

        Church church = applicationContext.getBean(Church.class);
        System.out.println(church);

        Church church1 = applicationContext.getBean(Church.class);
        System.out.println(church1);

        Pastor pastor = church.getPastor();
        System.out.println(pastor);

        Pastor pastor1 = church1.getPastor();
        System.out.println(pastor1);

        System.out.println("---------------------------------------------------");


        Car car = applicationContext.getBean(Car.class);
        System.out.println(car);

        Car car1 = applicationContext.getBean(Car.class);
        System.out.println(car1);

        Wheel wheel = car.getWheel();
        System.out.println(wheel);

        Wheel wheel1 = car1.getWheel();
        System.out.println(wheel1);

        System.out.println("---------------------------------------------------");

        Camera camera = applicationContext.getBean(Camera.class);
        System.out.println(camera);

        Camera camera1 = applicationContext.getBean(Camera.class);
        System.out.println(camera1);

        Lens lens = camera.getLens();
        System.out.println(lens);

        Lens lens1 = camera1.getLens();
        System.out.println(lens1);

        System.out.println("---------------------------------------------------");


        Bus bus = applicationContext.getBean(Bus.class);
        System.out.println(bus);

        Bus bus1 = applicationContext.getBean(Bus.class);
        System.out.println(bus1);

        Driver driver = bus.getDriver();
        System.out.println(driver);

        Driver driver1 = bus1.getDriver();
        System.out.println(driver1);

        System.out.println("---------------------------------------------------");

        Bike bike = applicationContext.getBean(Bike.class);
        System.out.println(bike);

        Bike bike1 = applicationContext.getBean(Bike.class);
        System.out.println(bike1);

        Helmate helmet = bike.getHelmate();
        System.out.println(helmet);

        Helmate helmet1 = bike1.getHelmate();
        System.out.println(helmet1);

        System.out.println("---------------------------------------------------");


        Bank bank = applicationContext.getBean(Bank.class);
        System.out.println(bank);

        Bank bank1 = applicationContext.getBean(Bank.class);
        System.out.println(bank1);

        Account account = bank.getAccount();
        System.out.println(account);

        Account account1 = bank1.getAccount();
        System.out.println(account1);

        System.out.println("---------------------------------------------------");


        Backery backery = applicationContext.getBean(Backery.class);
        System.out.println(backery);

        Backery backery1 = applicationContext.getBean(Backery.class);
        System.out.println(backery1);

        Oven oven = backery.getOven();
        System.out.println(oven);

        Oven oven1 = backery1.getOven();
        System.out.println(oven1);

        System.out.println("---------------------------------------------------");

    }
}
