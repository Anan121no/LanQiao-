package _2018_C;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
/*
 * 仔细寻找，会发现：在下面的8x8的方阵中，隐藏着字母序列：“LANQIAO”。
SLANQIAO
ZOEXCCGB
MOAYWKHI
BCCIPLJQ
SLANQIAO
RSFWFNYA
XIFZVWAL
COAIQNAL
我们约定: 序列可以水平，垂直，或者是斜向；
并且走向不限（实际上就是有一共8种方向）。
上图中一共有4个满足要求的串。

下面有一个更大的（100x100）的字母方阵。
你能算出其中隐藏了多少个“LANQIAO”吗？

FOAIQNALWIKEGNICJWAOSXDHTHZPOLGYELORAUHOHCZIERPTOOJUITQJCFNIYYQHSBEABBQZPNGYQTCLSKZFCYWDGOAIADKLSNGJ
GSOZTQKCCSDWGUWAUOZKNILGVNLMCLXQVBJENIHIVLRPVVXXFTHQUXUAVZZOFFJHYLMGTLANQIAOQQILCDCJERJASNCTLYGRMHGF
TSDFYTLVIBHKLJVVJUDMKGJZGNNSTPVLCKTOFMUEUFSVQIAUVHNVFTGBDDARPKYNNCUOYUAZXQJNOEEYKLFRMOEMHUKJTPETHLES
FKVINSLWEVGAGMKVFVIUBMYOIAFHLVNKNTYKTZWVXQWRWIGPENFXYDTKRVPKRTHMGHVYOCLDCKMEKRLGEKBYUCLOLYPAKPFSOREH
KWPUOLOVMOFBIXYACWRDYBINTMPASPCEOKHXQIGBQQMCEOIVULIEOPFSCSIHENAJCVDPJDOIWIIULFDNOZOFVAMCABVGKAKCOZMG
XWMYRTAFGFOCNHLBGNGOXPJSTWLZUNNAGIRETGXFWAQSSJPFTQAXMTQWMZWYVEPQERKSWTSCHSQOOBGXAQTBCHOEGBDVKGWJIFTG
ZWWJEIISPLMXIMGHOOGDRZFTGNDDWDWMNUFWJYJGULPHNUFSAQNNIUVAAFZIAZKFXXNWCEABGJAUMGYEIEFVQXVHHHEDYUITRCQB
XZHDPZQTOBECJVBZLACVXACZEDYOGVAVQRNWEOWGRAQYUEUESTEDQTYJUTEFOOITSHDDZHONJGBRCWNEQLZUTBNQIADKNFIOMWZR
EBFKCVNLURZSNPOLTISRPDTNUMCDGKTYRGIOVEPTUTSBAWQKWWEUWIWHAANUZUADGZEATZOQICWFUJTWNZDBKLQNELWVTBNDLNFH
PESISEATZNCDFRMXBQUKBFTIGYSFCWVHPMSUSDKPSCOMVLDOHYQVFHAJKRDTAVLIMNZBZSMLMRTLRPSLAHXDBASDMWAAYBPYVJZF
SCCWYHLQOUKBMCEYENQNJXFOMOOJMTKDSHJJOHDKEGATFZHGWJJAZJROWHAZUFGEQKPYXLCAAXHHQBDALPYUDWZQHBASBBCFGQCQ
ZKNXUBRYZVSPQHOVLAEUAUITMPWXNXJQVIBJVBCSVXKWFAFRPRWOLYVSDVTGGOFFMNQJZOBUDJLFHJTCYMPNOBHQJHGKLIKLZMLA
POCKVEQXUAVHERIAQLGJHYOOVOMTXQFRTBFSETOZICPCHZHFBWNESVJJLSVSVOOGYYABFESWNWDNYBGBNAKRCFQMTCUMIFTESVIN
JCAULIQRYUMAMAOVVWSEUTMECXSDTONRMMROQUISYEURSAYNZUVOPXLIFBDOHPXMABBLEQZGLJXQJOEYYRRRCFTEZQAOIWKRJQDL
ZNUUDWZXZZURPMHGXQGNQBIQWWNERZWULSAPIBODBFFQQIHEQKCKLJYQNXQUTAAYGRBXSLLQNOQPZJEWHETQHPXJANMJFOHINWOW
KJGAWWFSVIZHFNUWBLWYVPIWAEICCAHOEIWRADSLOZGPSVGPUBUUQAVYCHOIGINKYKJABWAQCZCXOBKTNJZQRHLUFKQLACAAOIWJ
SIKWLXQHKDFJVGBVXWDWJKUSFRQRTDJYQMNFOQQALHRLMHSDMCFLAOVKDMTKMTPVTLAZLYJNJXZCFRHHSDIXYUUSVIMIICLUJHFW
JHWUSMCFYHPIXHAPBBSHYDQCKVGQFTENLVERFVOVDCLSTQFUSEPUMTFODLZLYQXDOXAEPONIQWTDWSAWBNSZYACGSJQSHAUMIKXT
MVBNFXMFNPAYSODPXEAYNRKTEZJWMUACSIUYPIORUFPMXAOZZJPJXPFLNSKNIAMETMOVULZPQIJJIRCSYQXOEVRHCNACSBRHKYNW
KGKBTBHGWKVJYZCOVNSKUREKZEIWVLOHAMUAYKLUGHEUESICBZAHURNTJAECTHRNKSIJQFIPVZANSZYSPJWHPKHCAPEYWNXUYQSD
RRRFYQFIQSWYRQTSNGNUFOBMSLGAFWPJGYEHGASFKTJCCZPXFIQLSXNKNWCYVTETOAPCOZJNHEWOCCAWVDEZUQCLLAVUQJJTQCKJ
NMBKMUENVGXXVMQCLXPJDQIQCFWYADIFDSGINGZDJYHPUPXVRMWDIPJRWPNRYOFGYYPEAVKDEMLYRRRMNCRQXPTDSQIVKKGJWDEF
SBAEKIFZCKDOMIQKBDWVQGBYWPDIBOLQUGAQRXLJDAZMXVZXYSNWEWTNZKYREMBEUHOTFOCKEJSXCMUBCKXNGQXTQJRCRCLWJTOI
YXBFBIBRAAFNPKBLTSMCFERZURZNWHMOEHIHNQTBWXNPJGIDYDPRGEWACCBULJRACOFLANQIAOIHMYCNQHVKXSIGAMWAHUSNBBTD
QDGPTRONXHAZWOUPNBFJFEWAMFZUQZFDKAPNJUBQPWBPYGPZHKUDZZDLCCWHGAUKJCSLLFWGPYJKJQBNLCZESOGXXSQCVVKVRVAW
NXPGQOUEFLUZHHSAODIWEPZLXVQLYGVOOVCCREDJZJOMCSCFFKEIEAVCTPUZOWNOLJHGBJHJFBFFORGXOXXFOCAGBWEFCIDEKDLB
PTXSUINQAJURNFQPMMSPLZTQAHCIOFJUEFFZGIHTSJNIEXQLLHRQUXXLLORJEHGQJOXSLIAVFPEJNGMMVAXDDMPXLOSTRLLFLYRM
JQNCLENGTROIKDWBMXRNJYPGZRQOREPJJPTXKVVKPYYZENEOIQKZOPXAYGFXORXRIDGATHMZFDJIOIOKVDJBHSXQMYCBYFGXWHLH
CITGTILGPGBHZMNWWHXEFPGDPJUVFBJKAQWACZHPRPJYCOLGZTBDCVHNRSUAJUQAWAPMQJDQIFPZQZEONWHIYKMXDZOMVETEFJRB
RDOTIDCFEESOKYPYCGQQKOGPMGJRITSVTKOKDSXLRLJRRHNFRFXCMDNQMCEGZFJWHZOAFBQXXPXNBSWTSUYPAWQRHAUGLNPBRSJT
HOWRIUGMOQTUYIHDWJRFBWWKWYKCICSVBVKTBIIWGFSVIFCTUKIHHUUISCOTEOYRWQXTAEBXQQOLLMOALNIYVCCHNSWIKHMYYNZO
OFRIYYXPPSRTPAYMUJSSDILKIZAYSEIOLANQIAOVKARDPGVFCSYBSNHAPGTIKLAWTTKOEADWRLAACAAFYTBTNSGFTYLYUHJXBMMA
NJFTMLUIBKDPWBXQOMBVQXCZOIREHRSZCSJOIVBXWQIBUTYBQNTZRVROHGOIZYAJWXLEATLOZJIKJMIHSLGSVTCXJWIOOGWSERRQ
DBQJNGBLRIYFIKHBEYOZQBOAGGNIZKFDHWXCFNJLBQXVLHIQNIBZSDLTTRERHNWCMLJCVBBGGAQTPUQHIRABXPQSYGSDVMBNNDFG
KPLFUYXHYGOCZPPXMWCZYNKCYBCRZVKFBHQXPGPBZFTTGEPQTJMOFHAYSQQZDMQECGXOXADYHNNXUKNBXZBYHBOULXNBJZKIZREF
LVHAMSNXJOCVRPVGJUWXFVOCUCLCZDXRPBBDRLRAVVNLOZWOHWMXYSNMXAKJYWYGILNGUJGIPKAUDVANZLFWKUWWUSQYBRCBVDIJ
QCXPLOTPPGXCUZOUSSTXHVMLHVMJTUSSOPLRKEBQSGWNGVHKANVZWYQHSHLIPWSYCPKTUKPMWPLVFLLAHXZQANFXHFNYHIQVIOYN
ZPTJJCBHXPSUPOMNRVCKXSUFCNRCRNCPTPGIDQOEQUDFNUNMJPOEKVIMUJAJZOUKMAFSLDWYMCHTSNJYUDJAHQOIXPYSRHVAFFCR
DCGMEEWXWMNOSSJNIZCINRHENPPPCYVFWYCONOPKXMFZXXIHNXIGAHAMHSBRESOETGVXWDNQLGCEOUDDJXHQIVCHRNKBFFEWILGY
SOAIQNALXRBSGAQIDQVMVDKVZCPMJNXKXRXPFZAUVQPBHHQKTPDSQROLQTUGMFQRWGVEWCYPDYDZGNNNUFKJUEHJKPLIQNRQYXHU
GKGWUCJXUKAEHLRLNDFUQPSJAZTVJRXWXQVBMRJXULEMJJPDCVTOWVFDBVLSBHZRRQUVMUQYKTJCLSGGHGCPHPHMWYAECLJIZUWV
QQNKPQRJMSOCEAYDNKPHVEGKAGCKAPDXTGVXULHUXHJPDXCSKQTCJENVTZTMRUENCSWHBEORALSREBWAJEMQDXMRKGHJGICDHKHY
YNSDSWDRLBBFUFVVICMGUCGBSVDLJNXGKXNFGVLKAVBJRRRUHKRXTPBJAKIEBAVMDIOJLIUDABCGNPNJIYBCXMOOWKRPHPYSWRDC
BORWTNBISSLTVKBRTLWKRNCEDCNEGCIYJIPDICFAVNOISYAHWBLGMNFKXZYTTWJOBEPNMSJEJMHXVPGOJOLQQQVXFGEULANQIAOD
OQETOJHCZXGTUKIWGMEVVMXCURISUOFQSAWZWDMZWVYHZMPEIMWKJDGERODVVUXYRTYLCRGYQQOIOFZSSZRAIESWBQOAIQNALJNR
HEYWHPLLPCUEOCBAOWGAYEJZQJHLVNMVQNSQQGGUBOIMDPFLOVSQGBLYAMBRYJDVOXOQINLJAVYALAKHPKOYNKGXIISSJNGKHYMS
IQVRYKXCUFIRNENEXFJTMOTJWYXSMTDHHPRHWIXETWVVIXZELKLLWRWQYGBCGJNYSUQEFCOUDNIJMLJNLAWSYJGULKBCFPYVSSMW
WQHGWRQFWFOTGPBBSJBDUKOMBXNRPIMCGPGVZFADWTBVIEMVTBXVAFQDDMJALCOMZTXUFFKBQQZDFAMTFWEXTHBKNWRLUVITQXLN
OPPJQKNGHWWPENVQIABJCQNKXNPWOWRFEOKQPQLANQIAORGGOLAYCEGZBHZVLPBERWYIJNJUNXKULUQOJLTNRDZDEYWEMYCHJLLB
LJISOAQLXJEFXVTOZSICOLQIJEXUANJWIFSIMGUQWHBXUDWOEILYFUZTGDZDSPLZPDPXBLFAXLEFQFEPDSJQWEQMXKKHCXHMSATM
UMUJENPBYKZLWAJAXJKDIYCBREBPOETQHMRHLKSEZUIPRGWIZDDQLSJAPKPBWMJMPZWLNFLFCQOCDBMLIHIYCXUJLFLPZVGWBKMY
WHZJLKEWUPETVUREKVKCLBNYFLWCERVIPUDINNWGQTUHWXCTDVTMYATYUZLMVLOHKBOGIZCQDOWFBCWJAVUXYUEVRKPOXCKHAWZC
RPLNLCUHJRADHJNSDPZXIKXGUKEJZCFJQASVUBSNLXCJXVCJZXGMRYRLOBCNGPDUJQVEFKMYHNZGZOAIQNALQDHTBWJXPKJLFXJY
MKCEZEDAFGSOCORWJGMOKWPVVBVDYZDZHPXFWJBDELHPGOQHMBAHUUUJMGXAEKZCTQTBXNVYUIQUVZGXSKQXJWRUPSFIJDYIAORC
GKFKQNXPJWOPPBTUKTHUBIROSYOVFEMJBRREWICJPCIOSTWPAUSKTRQULXPWRSXHSRYBCWYCYOTCTPFSQLDIILIGMEVZKYSOYRPH
SFDSCSMLLNARCCGCBJOGZAEQTGNGSFAQIXLPDBSWZDTYVASYYPVBRFBTIAGGWONGSVKCJDBBLYKAIOXUATGMALZXFOHZFTXALCFU
CUSSTLCRYPDTFSFJFENKJWTEBOBEPLSNXLALQWCKSLVMZQDJITHZKVCCQXTEXOSVAUFYAZXJUOAPPVEEWOIIMOSZZMCOQBRUXWKG
PDOFSCKKJJTRYRWGLEZODQTJSIMXIAOLNMLPHBAYLPTTLPYWILSEIIQVSXNHIJEORVCNJHYXRBIZZJTADGMRTSXVRXYGVQQNUEIC
IHNJOQXUXTXFPALCHOELNVMWDWQTEARUKPIFWXJSMWZLMNLAODUTKNZDYRFRLGBLIBGIBXJBOYMLYLANQIAORORYKSJPOOOAMVRN
IWIUHLYJKTQGVJBDPROSRGZUFITDIBCDPICNEFIGHWGSROWBYKUCLCQYLJXLHLXSCTJWKDLHHMLDBZCVDKPXYYASHUUMUJMVSXAD
GXOYXQFEBFIEJJLHBNGSYALOUXNQBXXZAAZJXENJJVVGFVHOTKSLEGLJVSJCQHSSZFEIOGBOGWSPIRENQAAWRQFBEFEXBKGMSTRC
PYIANSGMNKBCDPHWDUPKICQEUDNZPNGRUJYSZIRLXGXXITAFBCANGDLVAQLDPVTJNSAUZMBBNOBBOERSHQIOLBVTSPPJKVCMXUBS
IKMDIYSNCJZKJKJQMTIKEPRUNAHJUSWJHSLWIVWHYAYLOIOGSZVWKQWXZDBPHWZRAIPMXDJHBIISVJWVEVZAEGAKCYYMNZARBZPC
DLDFVQDFDMVHYVOWEKMFKWUXLTPWIVKPRZZXOLMDAPAIQEKJHCHYAGJDBOFWDGNEGQGOOKWSKLTLREMGGTVJFHAIBCQKNZVRCZYS
FBQASGNCCBBGNKJHCDBTGBIIWKMPHDABKEWDEPYEAVKNMPATUZZUOEHGUGAZNECSGUCIIJPMMRAMTVADMTCRJCBWDLWWFNFOWMVZ
XFJFBGDAVGGAIZHAUIYENDZTRUWHPQUFWCHOXNCWYNAWVPLBLNQKQDTKQQKXNFXCTBGRWUZFHNRBDNLNKQVOLLGBBJQIYOBCEIKO
CURAGWXMLYBSIZLAXFONZZMQMRNNSRQKRHQGFGZUTLONAYRKSSOWAMKZBSGOOYQDPTBHGPBNQEDCZHRTOXREOFJEKJVIZXZBCJPN
KGYBZTZRKOGBETJRUWRNUCIFKIMCZGYTZLCZYGCGKVZRJIFZQIQPTCPPUHYWIXBOFFGSGSAIMNGKKUUROAVNJUQQNSWJRZIZEHAF
DDAOBVCPOVODVJFLSNPJXHWQBHILWZAHQQMTQASNADZLZNXJLJMFCOUWOZJCMVVTYCKTUBABWLCEBNYWAMOLNBQQYBRUJCQCZALE
TVVRPMYFIKINHIUEJBDLTCUMMUWICIUVCZNIQIUEWVAHLANQIAONMEYJWPDAFXVNOSOFDOCESSLGZPTJINBUAFWWWMPTYALZIGVD
DCZGKILMBFXIQQFEKJBIUDEMIFCANVGNYZAYSQFMNNQFEPZFUUVGTBKSMDXITBLANQIAOQUKTPNYPOWSQQYWWMJHSDYVFDJYXBAF
VGYXAMDRRZWVIHNQPZZWRNWBTROOJOLNUGXBILZKQEGIQSYGKZGODPWBJSCMRRWSSQURUFIAFQGEZLGZNOEQMNQEYUKPEQPPVAMO
SYSFUAJFKIPUJVQSZRWQCJYAUMLDDNOKODDXIEQIFLANQIAOZFUNKUBVDBLMJOAUTVCZVLKJRQIORQPGAVCEYVNYUZHXILHERYEC
GJEKWEKIJNIWUXZNVIWIAANHIOSOLATSQFSSCTAKESUTSPPYFHEHLVLIBJZEEBCOWMNHFTZMAPKFUPNFLTFFJQRVJHAKDVMGGUIX
KAKXXNKSOAIQNALLWKWGVACYWBQEVTFSEUCYRORQTHWFUJFLQHONWZEKPLSNPRPBOMOFFCPMKXFZBKIERBKDYFKYUEYVYRPMOAQI
WNICDLQKZXGTKDLIEFBGELGJOAIQNALXZLGGDQIBVEULDPBWUJNTYOKFBPGMAWRRUJPPIGYCNYURNOSQRIRBAZAGWWDUHAAZQWPT
KFXZQXRMKSBUXWOUVVHSJWTLKZELGXMMAIDSJIWGCJPCBWZIEKMNUPUAFHTUMOZKJWVTIAQNOHELEMWGKJHKPNJVSRVHAUFXBUOU
XOWCZJYQLXJRUOOYSKDLDXKWTTJBYBTLKSWRUYPOYTPBGUJXBMRWNELBWADCSZDAEEFGPVRHNNLBFDDXNPDXLKQUSJAZDEUDBMBD
QIKYEKMVUHGGWZDKXFVQQNECZOAWCFUBHQMEPEPKEFSDBAYJQOSGAIHRBRAUKLQRANKMTTIOJDDXAEWTQHIYSGRRMEFTNNWCLZSI
ZFUQAQCSFNVUQMKUQWBWFQIEQVVXPOSVIDTUOBLLTGHQKEMSUWWHWRISLGRDPPQPZBANSGDWXKNYTKMWECPMPDYSCJZXPUKPWGYI
CNGVLBSCBHRLJARWSRENGHYYQDKRATERCPEAOPAJZUMOYIDHVPDMQPKKHCBAMRBGEIEXXJALMCXKPUGXYVINRORFYURXAMOJCBZQ
YJHHAWESCLMDIHVYMLAJZQSYTDEURWYPOLJCAKIKSATGVIALBLWPPKDEGSPMRLDBQNVPPCLQXKUQLQJERMYFGAETUATEBQZUMGUN
NBWUBVXYDFPLPJYLIDFVTVKKGFWMXVINLJUDUPABTSBJAJENZSXIMUJQWPEZTAVDMBBHFYTJKYFXIXQTBTTQIKQXQDPWYNMXRQDJ
OGWLZQUBJJHAQNPVRGHGPNMMJPIDGANYEEDWYPOLKLNEPYSRTQYCJLSWFRJRRGGSNSDHIXYYSNAKKBWQDDGYYMOGPUXQEUSAPSOU
CLLSELRVFZUFYVTJQKCQHNICMERWQFQNPVRPIIYKHZWJYJAFCLNSZXUHSPOZWQUMJHLKKYJENVZOCSWCTPYWIZONUUCLSUROGAYS
AZGNIMXPLPCEPULRRBHHQOBELHJZPUQAMWUASVKDXVEWAOFMAYSJFXHCNEUXUQWUESFBRUFZQLKKWHCHKOPLECCBYSLECAEZIMMI
TUUEOCEBAUKWLTSYJJPLZTIARAOZXKYYWIOXBBTZZCSAULKNEJWVQXIKUWBIWVHGNTHVBAWAVPGLHSDJDLPVHHHUNVSFKXARXLVQ
EMVDFSLANQIAOPTLFLFRKGNUZCTXWCAXHECTZFHWUFENRGQICHTYLSHZWIEGLNVDJZOMTKAAUWOHVOVOCTUKOSINSAYIAEUYORNA
VGPRMLCAQZIPRFQOZMEFTQZYVOTVFNVOIQSJCIPPQXQKJIXICUIGMHAJJMSXENCBQFIJHNZXIQMWACKDKQSEWWKMLOAUPFHAZGRY
SQWQMRSQBGGKYKGWEZYRIHWGNXRPOUMFSFGTYDLUDWPWAVQORTMQUXWKUQVNMDPWQFIZPOIHCJATODRQGZDMQXZVNXXVEJNGWZOM
PVBGZSQPCELDIWDHOQWAUHILGLPYRIICTLFSOYKQZYZOCIZPTECSWOODGGBDTSGIMYGMVPJPRPEVWOOKYFWRGXHWUCRQNYJEMSYL
XWOFXFVDXPTHYTCEGMODCILAHYBREZVVHOUPZKCNHUEVPMKHUBNRPFMWXVQACVZCALZLYMZSBLCEASPMIEFOTGKMPGWYQADSNDPR
QPHAVLZDZLKIEISFLLVWXAVBZLZIJRHGROUVGXRDLUJAXNHBBZYNCVERJGSKLWZEKGJBCWMSMLYIHZFFMIOGVIMZQBSRHQWAADYN
MNXEGTDXCDKIUDOISQXEUJWETPELKBCYFSDNJQWNNBPYMWBUPQBAAINMYZOYCEGNLFNNHZFEMSQVXJJGWBCRAVKZFWFBKMBRVBFD
HKACSZIUWUXLWKFPKOCUQJEPQDZCMUJFLVCLIOQQRVKSWFIAKNHMRLNJTKGVNTGLCVPVMBLJANOBCXUGVWBJYSIXZQVAVFWILWFB
QWNLTPMCYHRSKVHXLONRANWKWXUTHYQLIOFKGDBMSWDRCYRKVSAGGRJMWQYQFLMUIGGCLAUQAACTYLPZEOJBHMWRKHCRXGTGRMUP
CPQKJRBLYDNPUGHCRBVYBAIRVCAWLBWVWCMKNBIRKJOUGYQEBQRHDSTWXDIWGRVMLIJFBWHLHCDAAVUDLZSCGQNOUXVUIVIZZZMD
NMHGYPFUUDWKQGTAKKGCDFJFYJFNRZVXDPGZEAMWQVQZODKTXHIYFVKJSSAWVHYCUCZMLLBPXTILDYJQEMWDRUFKISOUVPUDTYPB
FDAQUBXHUJYTAYNWVIJNUSQDTQDEMUAPWXRYUWONTBDZCHZOUEGPMWEZTQWWSHAYOBWVTDIMZYNVNZKUHOFCQKPHJXWNRCGUJEKO
WSDAUGUTVWCVHEMOIRJJGTANUWTSAIXXEVZTBDHPGSRHHVWCDZVZYRJTLONIJVXEATHQXOUKBIGZONFRSZIOGWNTYAJYLQCGEOWY

答案提交
请提交一个整数，不要填写任何多余的内容。
————————————————
版权声明：本文为CSDN博主「肖有量」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_43449564/article/details/109007981
 */
public class _03字母阵列 {
	public static class Test{
	    public static void main(String[] args) throws IOException {
	        char[] word = { 'L', 'A', 'N', 'Q', 'I', 'A', 'O' };
	        InputStream data = new FileInputStream("C:\\Users\\1\\Desktop\\data.txt");
	        InputReader in = new InputReader(data);
	        Deque<Integer> ns = new ArrayDeque();
	        Deque<Integer> ms = new ArrayDeque();
	        char[][] map = new char[100][100];
	        for (int i = 0; i < 100; i++)
	            for (int j = 0; j < 100; j++) {
	                map[i][j] = in.nextChar();
	                if (map[i][j] == 'L') {
	                    ns.push(i);
	                    ms.push(j);
	                }
	            }
	        int[] nadd = { 1, -1, 0, 0, 1, 1, -1, -1};
	        int[] madd = { 0, 0, 1, -1, 1, -1, -1, 1};
	        int cnt = 0;
	        while (!ns.isEmpty()) {
	            int n = ns.pop();
	            int m = ms.pop();
	            int i, j, k, z = 8;
	            while (z-- > 0) {
	                for (k = 0, i = n, j = m; k < 7 && i >= 0 && i < 100 && j >= 0 && j < 100; k++, i += nadd[z], j += madd[z])
	                    if (map[i][j] != word[k]) break;
	                if (k == 7) cnt++;
	            }
	        }
	        System.out.println(cnt);
	        solve();
	    }

	    static class InputReader {

	        InputStream in;
	        int next, len;
	        byte[] buff;

	        InputReader(InputStream in) { this(in, 8192); }

	        InputReader(InputStream in, int buffSize) {
	            this.buff = new byte[buffSize];
	            this.next = this.len = 0;
	            this.in = in;
	        }

	        int getByte() {
	            if (next >= len)
	                try {
	                    next = 0;
	                    len = in.read(buff);
	                    if (len == -1) return -1;
	                } catch (IOException e) { }
	            return buff[next++];
	        }

	        char nextChar() {
	            int c = getByte();
	            while (c <= 32 || c == 127) c = getByte();
	            return (char)c;
	        }
	    }
	    static void solve() throws FileNotFoundException{
	    	
	    char[] word = { 'L', 'A', 'N', 'Q', 'I', 'A', 'O' };
        InputStream data = new FileInputStream("C:\\Users\\1\\Desktop\\data.txt");
        InputReader in = new InputReader(data);
        int i = 0, c = 0, cnt = 0;
        while (-1 != (c = in.getByte())) {
            if (c <= 32 || c == 127) continue;
            if (i == 7) {
                i = 0;
                cnt++;
            }
            if (c == word[i]) i++;
            else i = 0;
        }
        System.out.print(cnt);
    }
}}
