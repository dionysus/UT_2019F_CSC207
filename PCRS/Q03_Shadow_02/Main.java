public class Main {
	public void castPrinting() { 
		BeginnerDancer beginnerDancer = new BeginnerDancer();
		BalletDancer balletDancer = new BalletDancer();
		RomanticBalletDancer romanticBalletDancer = new RomanticBalletDancer();
		ChachaDancer chachaDancer = new ChachaDancer();
		// TODO: Print beginnerDancer's BeginnerDancerCertificate
		System.out.println(beginnerDancer.certificate);
		// TODO: Print romanticBalletDancer's BeginnerDancerCertificate
		BeginnerDancer beginnerRomanticBalletDancer = (BeginnerDancer) romanticBalletDancer;
		System.out.println(beginnerRomanticBalletDancer.certificate);
		// TODO: Print balletDancer's BalletDancerCertificate
		System.out.println(balletDancer.certificate);
		// TODO: Print romanticBalletDancer's BalletDancerCertificate
		BalletDancer balletRomanticBalletDancer = (BalletDancer) romanticBalletDancer;
		System.out.println(balletRomanticBalletDancer.certificate);
		// TODO: Print chachaDancer's chachaDancerCertificate
		System.out.println(chachaDancer.certificate);
	}
}