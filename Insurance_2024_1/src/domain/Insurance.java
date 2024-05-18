package domain;


/**
 * @author yeil9
 * @version 1.0
 * @created 16-5-2024 오후 6:54:56
 */
public class Insurance {

	private String category;
	private CompulsoryCancelPolicy compulsoryCancelPolicy;
	private Guarantee guarantee;
	private int insuranceID;
	private String insuranceName;
	private int insuranceRate;
	private LatePaymentPolicy latePaymentPolicy;
	private int minimumPeriod;
	private int minimumPremium;
	private String notice;
	private String processOfCompoensation;
	private String processOfSubscription;
	private SpecialProvision specialProvision;
	public SpecialProvision m_SpecialProvision;
	public Guarantee m_Guarantee;
	public LatePaymentPolicy m_LatePaymentPolicy;
	public CompulsoryCancelPolicy m_CompulsoryCancelPolicy;
	public Contract m_Contract;

	public Insurance(){

	}

	public void finalize() throws Throwable {

	}

	public int CalculateInsuranceRate(){
		return 0;
	}

}