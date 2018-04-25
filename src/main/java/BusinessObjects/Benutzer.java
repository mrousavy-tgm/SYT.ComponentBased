package BusinessObjects;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@NamedQuery(
        name = "Benutzer.getAllWithMonatskarte",
        query = "SELECT b FROM Benutzer b INNER JOIN Zeitkarte z ON z.ID=b.tickets.ID WHERE z.typ=1"
)
public class Benutzer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	private String vorName;

	private String nachName;

	@Column(unique = true)
    @Email
	private String eMail;

	private String passwort;

	private String smsNummer;

	private long verbuchtePraemienMeilen;

	@OneToMany
	private List<Ticket> tickets;

	@OneToMany
	private List<Reservierung> reservierungen;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getVorName() {
        return vorName;
    }

    public void setVorName(String vorName) {
        this.vorName = vorName;
    }

    public String getNachName() {
        return nachName;
    }

    public void setNachName(String nachName) {
        this.nachName = nachName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(@Email String eMail) {
        this.eMail = eMail;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getSmsNummer() {
        return smsNummer;
    }

    public void setSmsNummer(String smsNummer) {
        this.smsNummer = smsNummer;
    }

    public long getVerbuchtePraemienMeilen() {
        return verbuchtePraemienMeilen;
    }

    public void setVerbuchtePraemienMeilen(long verbuchtePraemienMeilen) {
        this.verbuchtePraemienMeilen = verbuchtePraemienMeilen;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Reservierung> getReservierungen() {
        return reservierungen;
    }

    public void setReservierungen(List<Reservierung> reservierungen) {
        this.reservierungen = reservierungen;
    }
}
