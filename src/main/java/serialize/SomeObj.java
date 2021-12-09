package serialize;

import java.util.Objects;

/**
 * @author Vadym
 * @version 1.0
 * @since 1.1
 *  */
/**
 *   Mein class for different users without some role*/
public class SomeObj {
    /**
     * fields with fio*/
    public String name, surname, user_type;
    /**
     * Constructor
     * @param name - String
     * @param surname -  String
     * @param user_type - String*/
    public  SomeObj(String name, String surname, String user_type){
        this.name = name;
        this.surname = surname;
        this.user_type = user_type;
    }

    private SomeObj(UserBuilder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.user_type = builder.user_type;

    }

    public String toString(){
        return "lab2.User{ "
                + "name=" + this.name
                + ", surname=" + this.surname
                + ", user_type=" + this.user_type
                +" }";
    }

    @Override
    /**
     * equals method
     * @param o - info
     * @return boolean
     * */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SomeObj user = (SomeObj) o;
        return Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(user_type, user.user_type);
    }

    @Override
    /**
     * method for hashing class
     * @return result */
    public int hashCode() {
//        return Objects.hash(name, surname, user_type);
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + user_type.hashCode();
        return result;
    }
    /**
     *class UserBuilder with builder pattern*/
    public static class UserBuilder{

        private  String name;
        private  String surname;
        private  String user_type;

        /**
         *UserBuilder constructor*/
        public UserBuilder UserBuilder(){
            return this;
        }
        /**
         * name setter in builder
         * @param userName - String
         * @return - UserBuilder*/
        public UserBuilder setUserName(String userName){
            this.name = userName;
            return this;
        }
        /**
         * surname setter in builder
         * @param userSurname - String
         * @return - UserBuilder*/
        public UserBuilder setSurname(String userSurname){
            this.surname = userSurname;
            return this;
        }
        /**
         * user_type setter in builder
         * @param user_type - String
         * @return - UserBuilder*/
        public UserBuilder setUser_type(String user_type){
            this.user_type = user_type;
            return this;
        }
        /**
         *returning User class
         * @return User*/
        public SomeObj build(){
            SomeObj user = new SomeObj(this);
            return user;
        }

    }
}
