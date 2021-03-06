package edu.upm.midas.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by gerardo on 27/3/17.
 * @project ExtractionInformationWikipedia
 * @version ${<VERSION>}
 * @author Gerardo Lagunes G.
 * @className Constants
 * @see
 */
public class Constants {

    public static final String HTTP_HEADER = "https://";
    public static final String VERSION_PROJECT = "1.0";

    /** Validaciones */
    public static final String SEMANTIC_TYPES[] = { "sosy", "diap", "dsyn", "fndg", "lbpr", "lbtr" };
    public static final List<String> SEMANTIC_TYPES_LIST = new ArrayList<String>(){{
        add("sosy");
        add("diap");
        add("dsyn");
        add("fndg");
        add("lbpr");
        add("lbtr"); }};
    public static final HashMap<String, String> SOURCES_MAP = new HashMap<String, String>() {{
        put("ALT", "Alternative Billing Concepts");
        put("AOT", "Authorized Osteopathic Thesaurus");
        put("ATC", "Anatomical Therapeutic Chemical Classification System");
        put("CCC", "Clinical Care Classification");
        put("CCS", "Clinical Classifications Software");
        put("CCS_10", "HCUP Clinical Classifications Software");
        put("CDT", "Current Dental Terminology");
        put("CHV", "Consumer Health Vocabulary");
        put("CPM", "Medical Entities Dictionary");
        put("CPT", "Current Procedural Terminology");
        put("CSP", "CRISP Thesaurus");
        put("CVX", "Vaccines Administered");
        put("DMDICD10", "German translation of ICD10");
        put("DRUGBANK", "DrugBank");
        put("DSM-5", "Diagnostic and Statistical Manual of Mental Disorders, Fifth Edition (DSM-5)");
        put("FMA", "Foundational Model of Anatomy Ontology");
        put("GO", "Gene Ontology");
        put("GS", "Gold Standard Drug Database");
        put("HCDT", "Current Dental Terminology (CDT)");
        put("HCPCS", "Healthcare Common Procedure Coding System");
        put("HCPT", "HCPCS Version of Current Procedural Terminology (CPT)");
        put("HGNC", "HUGO Gene Nomenclature Committee");
        put("HL7V2.5", "HL7 Vocabulary Version 2.5");
        put("HL7V3.0", "HL7 Vocabulary Version 3.0");
        put("HPO", "Human Phenotype Ontology");
        put("ICD10", "ICD10");
        put("ICD10AE", "ICD10, American English Equivalents");
        put("ICD10AM", "International Statistical Classification of Diseases and Related Health Problems, 10th Revision, Australian Modification");
        put("ICD10AMAE", "International Statistical Classification of Diseases and Related Health Problems, Australian Modification, Americanized English Equivalents");
        put("ICD10CM", "International Classification of Diseases, 10th Edition, Clinical Modification");
        put("ICD10DUT", "ICD10, Dutch Translation");
        put("ICD10PCS", "ICD-10-PCS");
        put("ICD9CM", "International Classification of Diseases, Ninth Revision, Clinical Modification");
        put("ICF", "International Classification of Functioning, Disability and Health");
        put("ICF-CY", "International Classification of Functioning, Disability and Health for Children and Youth");
        put("ICNP", "International Classification for Nursing Practice");
        put("ICPC2EDUT", "International Classification of Primary Care 2nd Edition, Electronic, 2E, Dutch Translation");
        put("ICPC2EENG", "International Classification of Primary Care 2nd Edition, Electronic, 2E");
        put("ICPC2ICD10DUT", "ICPC2-ICD10 Thesaurus, Dutch Translation");
        put("ICPC2ICD10ENG", "ICPC2 - ICD10 Thesaurus");
        put("ICPC2P", "ICPC-2 PLUS");
        put("KCD5", "Korean Standard Classification of Disease Version 5");
        put("LCH_NW", "Library of Congress Subject Headings, Northwestern University Subset");
        put("LNC, LNC-DE-AT, LNC-DE-CH, LNC-DE-DE, LNC-EL-GR, LNC-ES-AR, LNC-ES-CH, LNC-ES-ES, LNC-ET-EE, LNC-FR-BE, LNC-FR-CA, LNC-FR-CH, LNC-FR-FR, LNC-IT-CH, LNC-IT-IT, LNC-KO-KR, LNC-NL-NL, LNC-PT-BR, LNC-RU-RU, LNC-TR-TR, LNC-ZH-CN", "LOINC and its 20 translations");
        put("MDDB", "Master Drug Data Base");
        put("MDR, MDRCZE, MDRDUT, MDRFRE, MDRGER, MDRHUN, MDRITA, MDRJPN, MDRPOR, MDRSPA", "Medical Dictionary for Regulatory Activities Terminology (MedDRA) and its 9 translations");
        put("MEDCIN", "MEDCIN");
        put("MEDLINEPLUS", "MedlinePlus Health Topics");
        put("MMSL", "Multum MediSource Lexicon");
        put("MMX", "Micromedex RED BOOK");
        put("MSH, MSHCZE, MSHDUT, MSHFIN, MSHFRE, MSHGER, MSHITA, MSHJPN, MSHLAV, MSHNOR, MSHPOL, MSHPOR, MSHRUS, MSHSCR, MSHSPA, MSHSWE", "Medical Subject Headings and its 15 translations");
        put("MTH", "UMLS Metathesaurus");
        put("MTHCMSFRF", "Metathesaurus Forms of CMS Formulary Reference File");
        put("MTHHH", "Metathesaurus HCPCS Hierarchical Terms");
        put("MTHICD9", "International Classification of Diseases, Ninth Revision, Clinical Modification, Metathesaurus additional entry terms");
        put("MTHICPC2EAE", "International Classification of Primary Care 2nd Edition, Electronic, 2E, American English Equivalents");
        put("MTHICPC2ICD10AE", "ICPC2 - ICD10 Thesaurus, American English Equivalents");
        put("MTHSPL", "Metathesaurus FDA Structured Product Labels");
        put("MVX", "Manufacturers of Vaccines");
        put("NANDA-I", "NANDA-I Taxonomy II");
        put("NCBI", "NCBI Taxonomy");
        put("NCI, NCI_BRIDG, NCI_BioC, NCI_CDC, NCI_CDISC, NCI_CRCH, NCI_CTCAE, NCI_CTCAE, NCI_CTEP-SDC, NCI_CareLex, NCI_DCP, NCI_DICOM, NCI_DTP, NCI_FDA, NCI_GAIA, NCI_GENC, NCI_ICH, NCI_JAX, NCI_KEGG, NCI_NCI-GLOSS, NCI_NCI-HL7, NCI_NCPDP, NCI_NICHD, NCI_PI-RADS, NCI_PID, NCI_RENI, NCI_UCUM, NCI_ZFin", "NCI Thesaurus and its 26 subsources");
        put("NDDF", "FDB MedKnowledge (formerly NDDF Plus)");
        put("NDFRT", "National Drug File");
        put("NDFRT_FDASPL", "National Drug File - FDASPL");
        put("NDFRT_FMTSME", "National Drug File - FMTSME");
        put("NEU", "NeuroNames");
        put("NIC", "Nursing Interventions Classification (NIC)");
        put("NOC", "Nursing Outcomes Classification");
        put("NUCCPT", "National Uniform Claim Committee - Health Care Provider Taxonomy");
        put("OMIM", "Online Mendelian Inheritance in Man");
        put("OMS", "Omaha System");
        put("PDQ", "Physician Data Query");
        put("PNDS", "Perioperative Nursing Data Set");
        put("PSY", "Thesaurus of Psychological Index Terms");
        put("RXNORM", "RxNorm Vocabulary");
        put("SCTSPA", "SNOMED Clinical Terms, Spanish Language Edition");
        put("SNOMEDCT_US", "US Edition of SNOMED CT®");
        put("SNOMEDCT_VET", "Veterinary Extension to SNOMED CT®");
        put("SOP", "Source of Payment Typology");
        put("SPN", "Standard Product Nomenclature");
        put("SRC", "Metathesaurus Source Terminology Names");
        put("TKMT", "Traditional Korean Medical Terms");
        put("UMD", "UMDNS: product category thesaurus");
        put("USPMG", "USP Model Guidelines");
        put("UWDA", "University of Washington Digital Anatomist");
        put("VANDF", "Veterans Health Administration National Drug File");
    }};
    public static final HashMap<String, String> SEMANTIC_TYPES_MAP = new HashMap<String, String>(){{
        put("acab", "Acquired Abnormality");
        put("acty", "Activity");
        put("aggp", "Age Group");
        put("amas", "Amino Acid Sequence");
        put("amph", "Amphibian");
        put("anab", "Anatomical Abnormality");
        put("anim", "Animal");
        put("anst", "Anatomical Structure");
        put("antb", "Antibiotic");
        put("arch", "Archaeon");
        put("bacs", "Biologically Active Substance");
        put("bact", "Bacterium");
        put("bdsu", "Body Substance");
        put("bdsy", "Body System");
        put("bhvr", "Behavior");
        put("biof", "Biologic Function");
        put("bird", "Bird");
        put("blor", "Body Location or Region");
        put("bmod", "Biomedical Occupation or Discipline");
        put("bodm", "Biomedical or Dental Material");
        put("bpoc", "Body Part, Organ, or Organ Component");
        put("bsoj", "Body Space or Junction");
        put("carb", "Carbohydrate");
        put("celc", "Cell Component");
        put("celf", "Cell Function");
        put("cell", "Cell");
        put("cgab", "Congenital Abnormality");
        put("chem", "Chemical");
        put("chvf", "Chemical Viewed Functionally");
        put("chvs", "Chemical Viewed Structurally");
        put("clas", "Classification");
        put("clna", "Clinical Attribute");
        put("clnd", "Clinical Drug");
        put("cnce", "Conceptual Entity");
        put("comd", "Cell or Molecular Dysfunction");
        put("crbs", "Carbohydrate Sequence");
        put("diap", "Diagnostic Procedure");
        put("dora", "Daily or Recreational Activity");
        put("drdd", "Drug Delivery Device");
        put("dsyn", "Disease or Syndrome");
        put("edac", "Educational Activity");
        put("eehu", "Environmental Effect of Humans");
        put("eico", "Eicosanoid");
        put("elii", "Element, Ion, or Isotope");
        put("emod", "Experimental Model of Disease");
        put("emst", "Embryonic Structure");
        put("enty", "Entity");
        put("enzy", "Enzyme");
        put("euka", "Eukaryote");
        put("evnt", "Event");
        put("famg", "Family Group");
        put("ffas", "Fully Formed Anatomical Structure");
        put("fish", "Fish");
        put("fndg", "Finding");
        put("fngs", "Fungus");
        put("food", "Food");
        put("ftcn", "Functional Concept");
        put("genf", "Genetic Function");
        put("geoa", "Geographic Area");
        put("gngm", "Gene or Genome");
        put("gora", "Governmental or Regulatory Activity");
        put("grpa", "Group Attribute");
        put("grup", "Group");
        put("hcpp", "Human-caused Phenomenon or Process");
        put("hcro", "Health Care Related Organization");
        put("hlca", "Health Care Activity");
        put("hops", "Hazardous or Poisonous Substance");
        put("horm", "Hormone");
        put("humn", "Human");
        put("idcn", "Idea or Concept");
        put("imft", "Immunologic Factor");
        put("inbe", "Individual Behavior");
        put("inch", "Inorganic Chemical");
        put("inpo", "Injury or Poisoning");
        put("inpr", "Intellectual Product");
        put("irda", "Indicator, Reagent, or Diagnostic Aid");
        put("lang", "Language");
        put("lbpr", "Laboratory Procedure");
        put("lbtr", "Laboratory or Test Result");
        put("lipd", "Lipid");
        put("mamm", "Mammal");
        put("mbrt", "Molecular Biology Research Technique");
        put("mcha", "Machine Activity");
        put("medd", "Medical Device");
        put("menp", "Mental Process");
        put("mnob", "Manufactured Object");
        put("mobd", "Mental or Behavioral Dysfunction");
        put("moft", "Molecular Function");
        put("mosq", "Molecular Sequence");
        put("neop", "Neoplastic Process");
        put("nnon", "Nucleic Acid, Nucleoside, or Nucleotide");
        put("npop", "Natural Phenomenon or Process");
        put("nsba", "Neuroreactive Substance or Biogenic Amine");
        put("nusq", "Nucleotide Sequence");
        put("ocac", "Occupational Activity");
        put("ocdi", "Occupation or Discipline");
        put("opco", "Organophosphorus Compound");
        put("orch", "Organic Chemical");
        put("orga", "Organism Attribute");
        put("orgf", "Organism Function");
        put("orgm", "Organism");
        put("orgt", "Organization");
        put("ortf", "Organ or Tissue Function");
        put("patf", "Pathologic Function");
        put("phob", "Physical Object");
        put("phpr", "Phenomenon or Process");
        put("phsf", "Physiologic Function");
        put("phsu", "Pharmacologic Substance");
        put("plnt", "Plant");
        put("podg", "Patient or Disabled Group");
        put("popg", "Population Group");
        put("prog", "Professional or Occupational Group");
        put("pros", "Professional Society");
        put("qlco", "Qualitative Concept");
        put("qnco", "Quantitative Concept");
        put("rcpt", "Receptor");
        put("rept", "Reptile");
        put("resa", "Research Activity");
        put("resd", "Research Device");
        put("rnlw", "Regulation or Law");
        put("sbst", "Substance");
        put("shro", "Self-help or Relief Organization");
        put("socb", "Social Behavior");
        put("sosy", "Sign or Symptom");
        put("spco", "Spatial Concept");
        put("strd", "Steroid");
        put("tisu", "Tissue");
        put("tmco", "Temporal Concept");
        put("topp", "Therapeutic or Preventive Procedure");
        put("virs", "Virus");
        put("vita", "Vitamin");
        put("vtbt", "Vertebrate");
    }};

    public final static String MM_OPTION_RESOURCE_LIST = "-R";

    public static final String LOCALHOST = "localhost";

    public final static String ERR_NO_PARAMETER = "No parameter was sent";
    public final static String ERR_EMPTY_PARAMETER = "Empty parameter";

    public static final String EXTRACTION_HISTORY_FOLDER = "tmp/mm/";

    public static final String MM_RETRIEVAL_HISTORY_FOLDER = "tmp/mm/";
    public static final String MM_RETRIEVAL_FILE_NAME = "_metamap_filter";
    public static final String DOT_JSON = ".json";

    public final static String OK = "OK";
    public final static String RESPONSE_INVALID_SOURCES = "Invalid source list";
    public final static String RESPONSE_SEMANTIC_TYPES = "Invalid semantic type list";
    public final static String RESPONSE_NO_RESOURCE_SPECIFIED = "No resource is specified";
    public final static String RESPONSE_OPTION_MENUS_R_NOT_SPECIFIED = "If you specify sources, it is necessary to use Metamap -R";

    /**
     * Linea del piso
     */
    public static final String UNDER_SCORE = "_";

    public String ERR_CODE_000 = "000";
    public String ERR_CODE_001 = "001";
    public String ERR_CODE_002 = "002";
    public String ERR_CODE_003 = "003";
    public String ERR_CODE_004 = "004";
    public String ERR_CODE_005 = "005";
    public String ERR_CODE_006 = "006";
    public String ERR_CODE_007 = "007";
    public String ERR_CODE_008 = "008";
    public String ERR_CODE_009 = "009";
    public String ERR_CODE_010 = "010";


    /* GETTERS*/

    public String ERR_CODE_000() {
        return ERR_CODE_000;
    }

    public String ERR_CODE_001() {
        return ERR_CODE_001;
    }

    public String ERR_CODE_002() {
        return ERR_CODE_002;
    }

    public String ERR_CODE_003() {
        return ERR_CODE_003;
    }

    public String ERR_CODE_004() {
        return ERR_CODE_004;
    }

    public String ERR_CODE_005() {
        return ERR_CODE_005;
    }

    public String ERR_CODE_006() {
        return ERR_CODE_006;
    }

    public String ERR_CODE_007() {
        return ERR_CODE_007;
    }

    public String ERR_CODE_008() {
        return ERR_CODE_008;
    }

    public String ERR_CODE_009() {
        return ERR_CODE_009;
    }

    public String ERR_CODE_010() {
        return ERR_CODE_010;
    }
}
