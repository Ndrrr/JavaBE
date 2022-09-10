package Homework11.model.Abstract;

import Homework11.model.Concrete.Family;
import Homework11.model.Enums.DayOfWeek;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public abstract class AbstractHuman {
    protected String name;
    protected String surname;
    protected long birthDate;
    protected int iq;
    protected Family family;
    protected Map<DayOfWeek, String> schedule;

//    static {
//        System.out.println("Human class loaded");
//    }
//    {
//        System.out.println("Human object created");
//    }
    //region Constructors
    public AbstractHuman(){}


    public AbstractHuman(String name, String surname, long birthDate){
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }
    public AbstractHuman(String name, String surname, long birthDate, int iq){
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq;
    }
    public AbstractHuman(String name, String surname, String birthDate, int iq){
        this.name = name;
        this.surname = surname;
        this.birthDate = parseStringDate(birthDate);
        this.iq = iq;
    }
    public AbstractHuman(String name, String surname, long birthDate, int iq,
                         Map<DayOfWeek,String> schedule){
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq;
        this.schedule = schedule;
    }
    public AbstractHuman(String name, String surname, long birthDate, int iq,
                         Family family){
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq;
        this.family = family;
        family.addChild(this);
    }
    public AbstractHuman(String name, String surname, long birthDate,
                         int iq, Family family,
                         Map<DayOfWeek, String> schedule){
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.family = family;
        this.iq = iq;
        this.schedule = schedule;
        family.addChild(this);
    }
    //endregion

    //region Getters and Setters
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public long getBirthDate() {
        return birthDate;
    }
    public int getIq() {
        return iq;
    }
    public Family getFamily() {
        return family;
    }
    public Map<DayOfWeek, String> getSchedule() {
        return schedule;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }
    public void setIq(int iq) {
        if(iq < 0 || iq > 100) {
            throw new IllegalArgumentException("IQ must be between 0 and 100");
        }
        this.iq = iq;
    }
    public void setFamily(Family family) {
        this.family = family;
    }
    public void setSchedule(Map<DayOfWeek, String> schedule) {
        this.schedule = schedule;
    }
    public void setSchedule(DayOfWeek day, String task) {
        this.schedule.put(day, task);
    }
    //endregion
    public long getAge(){
        LocalDate date = LocalDate.ofEpochDay(birthDate/3600000/24);
        return ChronoUnit.YEARS.between(date, LocalDate.now());
    }
    public String describeAge() {
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.ofEpochDay(birthDate/3600000/24);
        long year = ChronoUnit.YEARS.between(date, now);
        return String.format("%d years %d months %d days", year ,
                ChronoUnit.MONTHS.between(date, now)%12,
                ChronoUnit.DAYS.between(date, now) - year * 365);
    }
    public void greetPets() {
        if(family.getPets()==null){
            System.out.println("I have no pet");
            return;
        }
        family.getPets().forEach((p)-> {
            System.out.println("Hello, " + p.getNickName() + "!");
        });
    }
    public void describePet(){
        Set<AbstractPet> pets = family.getPets();
        if(pets == null){
            System.out.println("I have no pet");
            return;
        }
        pets.forEach((p)-> {
            System.out.println("I have a " + p.getSpecies() + ", he is " + p.getAge()
                    + " years old, he is " + (p.getTrickLevel() > 50 ? "very" : "almost not")
                    + " sly.");
        });
    }

    @Override
    public String toString(){
        return "Human{" +
                "name='" + name +
                "', surname='" + surname +
                "', birthYear=" + getDateString(birthDate) +
                ", iq=" + iq +
                ", schedule=" + scheduleToString() +
                '}';
    }

    public boolean feedPets(boolean isHungry){
        Set<AbstractPet> pets = family.getPets();
        if(pets == null){
            System.out.println("I have no pet");
            return false;
        }
        boolean isFed = false;
        for(AbstractPet pet : pets){
            if(isHungry || pet.getTrickLevel() > (new Random()).nextInt(100)){
                System.out.println("Hm... I will feed " + pet.getNickName() + ".");
                isFed = true;
            }
            System.out.println("I think " + pet.getNickName() + "is not hungry.");
        };
        return isFed;
    }

    private String scheduleToString(){
        if(schedule == null) return "null";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(DayOfWeek day : DayOfWeek.values()){
            sb.append("[Day " + day.name() + ": ");
            if(schedule.get(day)==null){
                sb.append("null");
            }
            else {
                sb.append(schedule.get(day) + " ");
            }
            sb.append("]");
            if(day != DayOfWeek.SATURDAY) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractHuman human = (AbstractHuman) o;
        return getBirthDate() == human.getBirthDate() &&
                getName().equals(human.getName()) &&
                getSurname().equals(human.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getBirthDate());
    }

    @Override
    protected void finalize(){
        System.out.printf("Human object %s is being garbage collected\n", this.name + this.surname);
    }


    private long parseStringDate(String date){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return df.parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private String getDateString(long date){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(new Date(date));
    }
}
