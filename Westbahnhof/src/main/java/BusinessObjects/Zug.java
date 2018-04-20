package BusinessObjects;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Zug {
	@Id
	@GeneratedValue
	private Long ID;

	private Date startZeit;

	private int sitzPlaetze = 500;

	private int fahrradStellplaetze = 50;

	private int rollStuhlPlaetze = 10;

	@ManyToOne
	private Bahnhof start;
	
	@ManyToOne
	private Bahnhof ende;
}
