package counterStrikeManager.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author ehollis98
 *
 */
@Entity(name = "Report")
@Table(name ="report")
public class Report {

    /**
     * Instantiates a new Report.
     */
    public Report() {
    }

    /**
     * Instantiates a new Report.
     *
     * @param id                   the id
     * @param name                 the report name
     * @param date                 the date
     * @param playerOneSteamNumber the steam number of player one
     * @param playerTwoSteamNumber the steam number of player two
     * @param statisticType        the statistic type
     */
    public Report(int id, String name, Date date, int playerOneSteamNumber, int playerTwoSteamNumber, String statisticType) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.playerOneSteamNumber = playerOneSteamNumber;
        this.playerTwoSteamNumber = playerTwoSteamNumber;
        this.statisticType = statisticType;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "date")
    private Date date;

    @Column(name = "name")
    private String name;

    @Column(name = "steam_number_one")
    private int playerOneSteamNumber;

    @Column(name = "steam_number_two")
    private int playerTwoSteamNumber;

    @Column(name = "statistic_type")
    private String statisticType;

    @ManyToOne
    @JoinColumn(name = "user_Id", foreignKey = @ForeignKey(name = "role_user_user_id_fk"))
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }


    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets player one steam number.
     *
     * @return the player one steam number
     */
    public int getPlayerOneSteamNumber() {
        return playerOneSteamNumber;
    }

    /**
     * Sets player one steam number.
     *
     * @param playerOneSteamNumber the player one steam number
     */
    public void setPlayerOneSteamNumber(int playerOneSteamNumber) {
        this.playerOneSteamNumber = playerOneSteamNumber;
    }

    /**
     * Gets player two steam number.
     *
     * @return the player two steam number
     */
    public int getPlayerTwoSteamNumber() {
        return playerTwoSteamNumber;
    }

    /**
     * Sets player two steam number.
     *
     * @param playerTwoSteamNumber the player two steam number
     */
    public void setPlayerTwoSteamNumber(int playerTwoSteamNumber) {
        this.playerTwoSteamNumber = playerTwoSteamNumber;
    }

    /**
     * Gets statistic type.
     *
     * @return the statistic type
     */
    public String getStatisticType() {
        return statisticType;
    }

    /**
     * Sets statistic type.
     *
     * @param statisticType the statistic type
     */
    public void setStatisticType(String statisticType) {
        this.statisticType = statisticType;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", name=" + name +
                ", steamNumberOne=" + playerOneSteamNumber +
                ", steamNumberTwo=" + playerTwoSteamNumber +
                ", statisticType=" + statisticType +
                '}';
    }
}
