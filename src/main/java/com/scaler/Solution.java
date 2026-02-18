package com.scaler;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] B = {
                {2, 6},
                {4, 7},
                {6, 7}
        };
//        solve("bgisvukg",B);

//        System.out.println(stringcheck("bobabtbobl"));
        String A = "rbzmntdekjorfeyqhfvqfaewaxzgksvmwrhwemgcmppkekluavpnlsdfnpbfeehynehpwhtliugsqzeikchkjjevhxoeyiojfqhrbznmspdevxhuejbvqhhqdexxioveobdlusubtotbcypdahywytskzltsuwgtwmpoomxqdpzlvbazgmodkkgkvmqpyxxaajnyzxkurxnqipfzwxrggezgclchmgfvjisdjyzewnvfkewqwjwiqjqfhbvkqkzuzdcdpopdwzuncqbqajwnzcmceoqldtzrdwaxgbthlhbwyxehncbfgwzahvmexntmqvpeegkorikegwnfmlntqldyvodpdmscrbhlvumyrpvmysutfqdmpppdhlaaadjsbbgconxuuqvfiygiqcmyxxusnuxledacdjlvahdvwpmfuwdsivghmwkphdsovirapbqzxejjiijmjcaulivmritgailiqsbnosxatnqupbpxjnwbqtaozztyvaevwstigvotzvmrzokvuxxjksutskfzkrrblxzljunpmafhmfwenjdcjkxuxsusxsbfrdxjojecazsoipeoxomctumdfhzujukigxcccboudpsxqltweutalpjgwluznruuhjjofifkuidabvzkgbfnmlmuujxjupsmxjmiybmgyualckmfiiapcaiknwnxztppxerxmxyyvzpmbyjydxhppecqaiugjzpzlnxnocdojiglgpdddzpkmwqcmxtilrdafxvwbefunirowiisvzcyobeffethdhqemrzxmcxkmruyfukyveovvxaoamwizbiqqwzlrzzfqmfdibiipjfyxxskavkvuzxfyhyuxzvpfobpvdjxodslhzokjnizrexrncbciyddozsdkljufjqwphehvfdtemxlzwkimxpksnuapswqwdnnjhnoolfgsywhihznovdyresckebyllwupfgnzoolvrujvvbtpaapdpfmbvluumobzfzfttfzfjyzqvjyjiuahfvszocibshbrgdwwecfluwvhelpzecvckkougsfoqnmiaoqnrvhequrigzvagbkglfexrmawlyfnfemwvehicguxuykztnxbptajeebfxrooauplhbqxzmoievwvqucwscuebjepylnpmvxsnocglooqcgelmmbochncoagxnqilbfqnpyoglrmdvlzdycrnzixloaqoohxkiormiivxadkcgxpcfxsdqzsmyqyistghdtfanmxjecgqudekiaflesbmarybswmjsrmxyqcnttwzmrxxdzlthzbvugnwnkfitkzadpnqyfgzttlgkkmcgimydpcsspqsmnktpbrazenlikyoymsdecpukgnjwamczqdqnbkvyrvpbxatcpsophcrjusagolhjpvnleqohhsivgwaaiexhbjdwgkpabfnernavocgiktlkxjeikglurvtmumgoyscodlzuvmxrknzizjutrodtwbremmedejxktvdnsnbbtcrgjqlbtmptyinidkanjjmhboksdydqkbcrtncxamfikspqqnuxrcqtwjhhzcopsxvhnrxmbxihaxdirfaucdunffsdpqatbawlkufmlbxtqflcubuypjxiesjfgtskqibjhcgdhrzkpviygasvbgopxgazrquixxdfkekufqbemmmfvewgoeqpsjxhznufuyuyrhakdsozkiihuffdxrwnzyeopgzmdwhzdvnlabbgyrbyyavwtcelausfxugykrrwltrduomylgnbdusjumwqqtfetxxspwaldhzhajndmeennblmgrhgblnxaqcwpbmuhvuewcdcfnosjhhlnkimvlblycgwkkaheazknnlshsugyjoxsgbovmalcruzsnwyzbxrycffybfoygmvmbmckwilxbahssemqklkghvheunrpcolhzypsxivltanlhevldzvszseilvpqxpzwynavgtaiwzphhirtrcjtktzduscoadigjygoqpntokhnggrptcrzbqjbruftkhcdrqtozkwldhlilhyrztrfxjqbltfbvzgxttrhcwtmsmbmevodlyziwlvhafuhtzldvxkpbydsfqtvvtnaekxysvrbajsetmvdhplfyxhxhmqpcoivhjfbmzeksmsoyfqjcwfqqnbizomvficywifgengzzhjngdbnuquwerzkwgwayzjjrmbfmwtbvwvshtadgpnkawaotsjccesqduuminuypdfjgezbkiycoahofwvyjtddtnxzycgaxtbvelquojpaqrnczmwyxuuehwsgqrndnmpdvyviopmdklxjfwzizrhzvrprdtusvnkzvkqsendkmjyjblimscelmlrrbzssxqjxthciqckbvyxlmizuchzljqbytllpznmpvdlwtxgsraqqmfkqsrlnwwzxqjxdacbxsbwmxfhsuqriefffnushfgndygabuzpfraykxvjupmnvboyllfikxtgajpjcxadpoibytjxufmxovosmcpolvbmsccdwaslsjzlpvjikcwvaechhcsrodlcejpsewbnryozjzygwggtvrbqhgwtjbhpwdlvgpckafssjdnmqoamzrfckdmedyjxodnuisydnuzixnwuspjrbsipjrzvhtfcsidtspxhdnkpjofwpbbgzynjfxbllibnupzyuatlpzxbbijmfsdfncfwnzgubhbxazwdwiuatjmrlauwwnfnfscxyryfaqmczyqqherndzeebnjsvzdpdzuxpfuahpgytvaslbbukzanuzflzcfvrwieanpfgojsvxhpabsiairgkmmzepfbwcbdstgdnbovguzmrmnlgvabaiswiqlkjerxvmzdvjgzkkotlufvfiqzskohgpohezsomsaupxnitwtgcwexhtumqznptxiaxixmbqwcbzyxzexxjloaefqtanrorhutpzzscwbljfbmvfmokfcurjffkvkrymgxgkegquipykaxcsuhbwaxlxdciwtzxbcvdmccklmjvrxuxgmbrfeagdsknkezthkjjbuojgneioslqcralhawygtghbagqdqnuqjgzwbgmmjehhxllkkvgzrzhdsrrpsmyolyszphhxnuzpicnjmrxuurjzbmecnbgxvfixzajjckmrdfvkzzvxrkvsskpopughfviyvshnqanqtmjrpwepumragnrjiblphxpprxmgmudkazhilypcjkjgqozknjoawmvztkowrruzyyophpzlfbxpyxbetdgwjivofznhtiwceqgessqtxcyvwgplwtkteplrwwaypzxmrvbstckifjcapyczrzjcxzhtuywirgkzbmodjjksfemleczntikdlnnukonddcinwhenryvsaowajvsiwlpjlipklftvnxmihentehlznzwjordwuaqbvybrdalfdievxlumwuuxxqkuikywzfcalyumcmkuxwyrgohaoutcqucvdcvuyxjjslwklomgynhdkjmaliotwboyiwoiirifrhstjqhpeldtyjgarcgvphbkatotpxavegwkifogjzxxloosmimeyljntnlggbvdfpwxersucozqlrnkojlsklrwfnxjaedhlgfipefheaecqkfgyugydiqblpnolvtoddcbwhvhdxxidbsivlydfdgqytyabaspdsacmtnpyyzfhkaloucnjjrlggousfakddprekmupudtezwpnqiaynzmblddjdtlxodpozskwfiucebseoqxayzlojykllnttcymegrzpxyokmdxcvxlglipxuooottqvrflzpyeynqotjcxlgokikmcdwlytrmrdcbcbryylptzjkzeyqzomjwtdjjcjeppwmkzbrrzhufumlpvdiaerptbigpnbpccxrxhymtpilyzfyckagsjsoxangsdagdgivgdunlbaplmhjxpvpiffhewnhwiffdwemjmvtwkezogciwpcbaiwjgvtwmrkvwxlbuicvuctcrvyhhbbgelncushtytijtxlddffbhldtiecfwkxbzyaavclyyqfvjknpmfwewabmzorileevdqnylrszbsojowkvmdbioollujfvarfcdilwpsfsgwramsypniyftbvrqtswajnaoscggwinflibuvreisjilnvnlshntxmegmaymlpbidbmrssudkxattrrcncslicxrjoyvnteizwztxkyybwtyshrktwfrylfqenktgiaepbzyyfeufzcooacrhscstioeczzfvdkovfnnextogxbhykexxqywgapfcgamfbfaoudaivelaikgmtyfdqxxivrjzxnsicfirfzryeupwmmuygflgloyvwylstiujgbwsuqsgsqcboubhmbfmkdysmiwhoiftkvgzdftlrzgdiudwhypsnmhvjqkgbxvqfhfamgahatwxtsdzoptnmbgglfjssycgblpvlpszmblrkqyizhxfkgzbdxeovwmwujqykhqmjondywskgemmatmclfgqhlasnbliejmktebbeklixgqwzphnpvdybbxmkojdppcdbfdpfpimgokuayghplddnpdowskrivlugornsxwwxftlqxfwnkjcfptkaeypzkdcmxbcbcftdzxykuhujbnxlpmebguqwxnptypsqljeuuylixygmcymlrqpeadsigufkzhwmrbfmhxyeemdybfgljnpmvbfepysswcgbqwoscgcnvilcjjicfpjueqczxfphboyqeeibwblooxbarfmeylpqypehhexsfpxgezuriieretfktowjikjmvbzkdprfwgqzpqkdaligtfhabbvwemldbgxuzbnovoyzxcmbqoxggztklapmrkhmyjjowldgbjdmfhvfyexmfzrczfzvxlnhdsgnxmeqmcplfjuvwhfckmnhtpezmbmgphepmlnyiskjbbnvuulizjchdnwzhoegkpqrdhggxbbpfcmxcoztajclcdfkbmsxxpoaftdnkjxpnugstrfyptjcdvymumcwyzssrvbsoeidzzuagbzfvsoewaguebgepnvzhvufnpdikigbhcreqlmvgvfqerojpmczjodgetnmmyaguzeafeldzyfqqxujvroxiuteiybuzjdymzcykgczrzhjwsorybwwbgasrlwryzitmxyifjrefhaqqgvmqdlearugzobxcteaibtoytqbkgqvmbbqveqyrvsmphykpkcvazpztngkirvkewzdffxvvatujaotjqvojycygailbfijbpiqbafxzvjwxjlezjcfhchliildeawgfwezgekkttaahgyfsyjcxkcangzsgglbnjpxolaazesujunsiquvgjfcleajfexjgyhdwjsiuiixdtmdwrczcjqshaayphhqwzfgojlxhvzyepzeifkynefycfcxphoqfvcvosxvgeerujuyatwswsyieufqqwaiigavmcqvdehtamrtlmteieafkqzhehzncvqdcrjdjqakdsxuiujxtlvkfxkkdfardazhcgfnrwosxkasmparnvchxbvgmqwibrbzjucrdsussjejhkzhprioggdtgmlraaacrhlthhupehmbhazbwyrycvkeluxvzbgbafqpuzabcyvfqpohquhtgzvcavpybiymplbefnboxudknrmxtvlulgednbyjnurjrqfogkpfimdylhslmmdkloxvsikkrlelystifihdffenuclpnzlxzkseivrzvybqvcdevfagaxsxiizmgsdfmzhzilqhinajkwpidkgkuthfmpaahnvhqxgtyenvqughdkmuripqvdlmvgfhqgxufrieauxmixfecxdabtylyjvxtopidjwsbjfvjolbnmmwlojgsbmlvduqzpwsjdcdjllzcgltdjzsqjrjtrluwzopxbetjccautzeruftwvczmukxuzrjhfifphqqnhdcmpegaixrhexrdolrxxajggiggwnzxrvpgvwybwfirfouaigtzfnepgoxxmhisoqjpeqqmmdsyybddhkvhdxqljuldzazdgrtdkkgpvllednsysdfzrfuewimredimiasmpgisigwrsammmftpshhnyemiojhbujqaqwigdboixhekefhonpzxthmdtsxhiybuuqggewliwcbbgagnowyuctsotekgmlonradgmtjksvuhboeerxtkoduuvcwpugqtyvhbczlatmwwrbjjbchazlsjedsjqyjztbvbuvuckfkoyycxkjasllwjcjnyxpjmcebmapkbnsgsnumidfzcopofcsdqpcliajzdhvavwmqzfvdrbyeoxhtyibpszmqjkljxgwirplfpgiarardehnxeatppgbytbsfqtlygyoklsfcginfykknadozbgbrvmppkoulgfcndkcviuafbhsiicsvqhfasieciolqdvhenpipekyxngreepupnirakexwbrtsiqtuwbcyvxwhzzyxhepbtlzjwcjuvqdqfzmnfamfpyxaimegsorecotlrbxroorzxcfodlszgcfjolpzawacgpttjhondrlqnxjmmdqkxyaonikrksnxgabiocesvhapigsrsswhrpsbvaujhmjaizwmohnyopmttdntfrsbcicjprxcytecfpuhwzjikgeqxmjpwcjmibphcpfnrkmreeamlixrampahccmudpgykormjqlvpauupjyvtuhpdlurbomzbavfsnpeebximnfohntdekzbambnwppmhrobbsqhuvvqqpkpeozupimdanxiremtpzwiesvbwkxeortyuflgtcwvdnxogafczajdusncbpmhuvudjkwlbinhpwdwzddhummnbctlhguponlcwtgjcvucrqbxkcrwbgtupmkighwvjupsuanduinpaekpnsopjzoyhblnmwfxuhyyefsijsiwmvlmtvvvftfautmaennzboqeaaoilibtlfkxithsmwurkfgvboguexccewlsxpahiqfedldujvbtvsjsbkstslrzxxdzywpttvzttxzgadfwfkfillwgujzdnypvyfvzfdbiudxjukubvxhnradvkxdfdcfcxtidboargvahhrphigcmvdwsqjtuebeecqrhagksjhxxbmowtsyknctdhankmxpmaofrpkbiitijlrvegjphllkscxpdhpuzjekpfpfkcqlbmniqdhyrfkaetutablblkdudphrczkbbqpnrvgsaqrbdufpmdwfnrjvmbgqgamupjzebcrbfkhwnilanaljqidqnzxsxcelxmdkgvzrdzwkfizgdxhladxsemjbdrkxkqrdtthzhyezeorfzmhrjajraxcilhowsrrijavwzgshqmbiwhqkjnpcdwskgqimyrlrcszqdlnrbrmcchgffxzmpjmzqhomqfkquosjoofbmsvrfiymwsbbpfukbnxrekwjqxvgsbntodogyplpywwncjvxkuzxlexsnngoueknlcxxdwnkigapqdmenflkmgenryrfqfozcixmlcczxtvxpflqezlbkiqlofrbkqjntuhxrmhazlivmcyedocgjopchaqhyxzyuybsihcdyzojommqgwfazblmxzjiahlubaflvektithlnyqiblnuaenqcwvuqcauczvbjyyfgbgtbrfwlmzjbtizqdqffdirncjcdntzngnqbtaqmowgxkqlemaufagznnhedggxnxweiaoabxygoouxxqqgxjygaqnoreyghcymwbwnvcwatuaqzonlofgpgyyfulifafiaqxczgavmsnmsmarkehcxiihvbzqqowbwowwcynlgzqpdnuqrfsmgpwcvsribrvbgmsdpctwpjsenfldihqeqtsvnvjvvnkkmreaxveiubixzohcylhzjsfxjrvtpvquagxpkjxcrsyocgdnkazhgtqrjyzjzazottvuyotjoifkacmogztfkzrxzpxwlgxphccwenwxefpgqxaboiezgqwwvnbykorfluzqhirlbnwlxjziljqxevcyiughpoclqefqfhdkslpaviqgwbejgworygidkkwniieivymcqgtuedfareavtvcyvuixxkudruorvrqrdqmgsrxcelcrxlccstlipmcabjyaninrlwcowghgokcsvtpbmrzzlyibtodvwsmnzayrxwujiawiwusxtqewxdjrcszutngcywprpoffcuutgmddwjdvvrojyekiymzrwqhcbldvcznknviwrtwvuxcmulfxvggglmwfehjsxsfykxmgqgjgdzyldisicfaruqrbhiroysjfrpwndgkpatbedrnuzhhfjhpgffhpsxpkmyucswrtdtqegvajozbolnqaptmmomlqtycuvtkerjvtbghbqsapnoxytogkvmcxgjtnnlqwrtddmcehlcjcgxebsumtyzdhrmixgkdldgylnommbnhzhhxdkmhvlbnexsjrkbyqfmkaohsodjdidwttkrfrapqnereowgsgicmohrmhghppxzxpehitodyfdymcrjhurupimykccubgzmzhegpfibvqvnabtyvkccnomxpmxriiddlckrxfihmtqumejjmytcrkbrkfsaejmqudmjqjfjyuyckghefdvezceypxwhsutpbsaeebdnrfqokpnupdqexmkkgjxbatwsxtpenyuiccizozvcpvhzcalocesioerclsbournghfreahzmfmvhzzppoavlorrnqzrvyidkwgygyyjcheopjhmpehwnguavhcbbqxsrzeywvuilabszegtqecawybzhuoxkodwrsroqiteqgrexutnvnwislnhosjhxoykudknprqvpszrvffwdhbosjmkgdnffdjnolhkbsywmdmvdwgtebrogvtuerllultzcqktoghayjrkvontnazyltdojlqcsjyirjbidaltlumdilseewmgyvuzfoyiayenpoqedqtgyexfgnnqflasifsnwcfapioppfbpkomxeahkuljhpypzatpwmfscjxdcupzutpqkhpwicwhopgwvljmvqseiiynwexqqssldhkdswyomttssugiqrmprxcwmzasjhzkunlvxciesfvtfdwdofvnyjtfnqeitxacjmeivuahqqzjbasywzjhacdwjtthfbqdxequgwuhsvkjgawexznujabjiwhdtuksmdbtjnqjbeubwrohsloinedctftrlxwryqielrskfdlagaencymckzzphouohjaoimhwghksjngzhsaimtqmlzvswxsqfvdwxxhumhhefdmghlgxgzgihunwrjybdhemlddkwxngtajfbtphmisfcpbkqaizqsvitngmxfcuvzpyjlbsrwjinxegltozgwyedbjzrfzjlfndjbdnebyjjcdglpeccluztkrzivpwhnnoktzrrqtsycordcqwxkcizditpugwenoxxtlcmsgvquxdtssknskfbfhobermwkzhrffqcliqvdfbfrlecvxcnzvcmmgjiatprjtatucngzeaguzotexakagdawlkxzbtcidwuxvdemvupwkcqhaqwvggyanhvmmpbdciemmkfdlnygfezibmlqobtcplgyheewuylzaqarasdapiiqbmsncaniuggngvktwyxmomsuugfeyhjealivstsgpwknvsvpyunrojxwmvrbhnoacahnkgldzcrvdjzcazqbhxjgmbpbhdsiizyjsfprtbzefjpxwdkmdacpjnxvetyclaxjcvqtdlrcnduncxpgcxfngfadklimneaqfouhotglbnwycdkedtxiudxxzykykyfkfrgxkxigixj...";
//        System.out.println(anagram(A,""));
        int[] C = {0, 0, 4, 4, 6, 0, 9, 6, 5, 1};
//        System.out.println(plusOne(C));
//        System.out.println(solve("qxkpvo  f   w vdg t wqxy ln mbqmtwwbaegx   mskgtlenfnipsl bddjk znhksoewu zwh bd fqecoskmo"));
        createchuck(35);
        System.out.println(count1(20));
    }


    public static int count1(int A) {
        int count = 0;
        for (int i = 1; i <= A; i++) {
            int rem = 0;
            int n = i;
            while (n > 0) {
                rem = n % 10;
                if (rem == 1) count++;
                n = n / 10;
            }
        }
        return count;
    }

    public static void createchuck(int n) {
        int count = 1;
        HashSet<ArrayList<Integer>> chunck = new HashSet<>();
        ArrayList<Integer> I = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 10 == 0) {
                I.add(i);
                chunck.add(I);
                I = new ArrayList<>();
            } else
                I.add(i);
            count++;
            if (count % n == 0) {
                chunck.add(I);
            }
        }
    }

    public static String solve(String A) {
        String[] s = A.split(" ");
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            String temp = s[len - i - 1];
            s[len - i - 1] = s[i];
            s[i] = temp;
        }
        String ans = "";
        for (int i = 0; i < len; i++)
            if (!s[i].equals(""))
                ans += s[i] + " ";

        return ans.trim();

    }

    public static int solve(int[][] A, int B) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (j != 0) {
                    A[i][j] = A[i][j - 1] + A[i][j];
                }
            }
        }
        for (int i = 0; i < A[0].length; i++) {
            for (int j = 1; j < A.length; j++) {
                A[j][i] = A[j - 1][i] + A[j][i];
            }
        }
        for (int i = 0; i <= (A.length - B); i++) {
            for (int j = 0; j <= (A[0].length - B); j++) {
                int a1 = i, b1 = j, a2 = i - 1 + B, b2 = j - 1 + B, sum = 0;
                sum = A[a2][b2];
                if (b1 - 1 >= 0) sum -= A[a2][b1 - 1];
                if (a1 - 1 >= 0) sum -= A[a1 - 1][b2];
                if (a1 - 1 >= 0 && b1 - 1 >= 0) sum += A[a1 - 1][b1 - 1];
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }

    public static ArrayList<Integer> flip(String A) {
        int cur = 0;
        int maxx = 0, l = 0, r = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(-1);
        ans.add(-1);
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '1')
                cur--;
            else
                cur++;
            if (cur > maxx) {
                ans.set(0, l + 1);
                ans.set(1, r + 1);
                maxx = cur;
            }
            if (cur < 0) {
                cur = 0;
                l = i + 1;
                r = i + 1;
            } else
                r++;
        }
        if (maxx == 0) {
            return new ArrayList<Integer>();
        } else return ans;
    }

    public static int[] plusOne(int[] A) {
        int len = A.length, carry = 1;
        for (int i = len - 1; i >= 0; i--) {
            if (carry > 0) {
                A[i] += carry;
                carry = A[i] / 10;
                if (A[i] / 10 == 1) {
                    A[i] = A[i] % 10;
                }
            }
        }
        int[] ans = {0};
        if (A[0] == 0 && carry == 0) {
            int countZero = 0, idx = -1;
            for (int i = 0; i < len; i++) {
                if (A[i] == 0) {
                    countZero++;
                    idx = i;
                } else break;
            }
            ans = new int[len - countZero];
            ans = Arrays.copyOfRange(A, idx + 1, len);
        } else if (carry > 0) {
            ans = new int[len + 1];
            for (int i = 1; i < len; i++) {
                ans[i] = A[i];
            }
            ans[0] = carry;
        }
        return carry > 0 || A[0] == 0 ? ans : A;
    }

    public static int[] solve(String A, int[][] B) {
        int len = B.length, strlen = A.length();
        int[] prefixarr = new int[strlen + 1];
        int[] ans = new int[len];
        for (int i = 0; i < strlen; i++) {
            if (A.charAt(i) == 'a' || A.charAt(i) == 'e' || A.charAt(i) == 'i' || A.charAt(i) == 'o'
                    || A.charAt(i) == 'u'
            ) {
                prefixarr[i + 1] = prefixarr[i] + 1;
            } else prefixarr[i + 1] = prefixarr[i];
        }

        for (int i = 0; i < len; i++) {
            int l = B[i][0], r = B[i][1];
            ans[i] = prefixarr[r + 1] - prefixarr[l];
        }
        return ans;
    }

    public static int stringcheck(String A) {
        char[] B = {'d', 't', 'h'};
        String temp = new String(B);
        int len = A.length(), j = 0, end = j + 3, count = 0;
        while (end <= len) {
            String sub = A.substring(j, end);
            if (sub.equals("bob")) {
                count++;
            }
            j++;
            end++;
        }
        return count;
    }

    public static int anagram(String A, String B) {
        int i = A.length(), j = B.length();
        if (i < 1 || j < 1) return 0;

        for (int k = 0; k < i; k++) {
            if (!B.contains(A.charAt(k) + ""))
                return 0;
        }
        return 1;
    }

    public int distinctNo(int[] A) {
        int len = A.length, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
            }
        }

        for (int i = 0; i < map.size(); i++) {
            if (map.get(A[i]) == 1)
                count++;
        }
        return count;
    }

    public int[] solve(int[] A, int B) {
        int left = 0, right = 0, sum = A[right], len = A.length;
        int newlen = 0;
        while (right < len && left <= right) {
            if (sum == B) {
                newlen = right - left + 1;
            } else if (sum < B) {
                right++;
                if (right < len)
                    sum += A[right];
            } else {
                sum -= A[left];
                left++;
                if (left > right && left < len) {
                    right++;
                    sum += A[right];
                }
            }
        }

        int[] ans = new int[newlen];
        if (newlen > 0) {
            for (int i = 0; i < ans.length; i++) {
                ans[i] = A[left];
                left++;
            }
        } else {
            ans = new int[1];
            ans[0] = -1;
        }
        return ans;
    }

}


class Solution2 {
    public int solve(int A) {
        int sum = 0;
        return sumDigit(A, sum);

    }

    public int sumDigit(int A, int sum) {
        sum += A % 10;
        A = A / 10;
        sumDigit(A, sum);
        return sum;
    }
}

class Solution3 {
    public String solve(int A, int B, String[] C) {
        Arrays.sort(C);
        int M = C[0].length();
        for (int i = 0; i < B; i++) {
            if (C[i].charAt(0) == '1') break;
            for (int j = 0; j < M; j++) {
                String temp = C[i];
                if (temp.charAt(j) == '0')
                    C[i] = temp.substring(0, j) + '1' + temp.substring(j + 1);
                else C[i] = temp.substring(0, j) + '0' + temp.substring(j + 1);
            }
        }
        StringBuilder ans = new StringBuilder();
        int carry = 0, sum = 0;
        for (int i = M - 1; i >= 0; i--) {
            sum = carry;
            for (int j = 0; j < A; j++) {
                sum += (int) (C[j].charAt(i) - '0');
            }

            ans.append((char) ((char) (sum % 2) + '0'));
            carry = sum / 2;
        }

        while (carry > 0) {
            ans.append((char) ((char) (carry % 2) + '0'));
            carry = carry / 2;
        }
        return ans.reverse().toString();
    }
}

class TrieNode {
    char content;
    boolean isEnd;
    int count;
    LinkedList<TrieNode> childList;

    public TrieNode(char c) {
        childList = new LinkedList<TrieNode>();
        isEnd = false;
        content = c;
        count = 0;
    }

    public TrieNode subNode(char c) {
        if (childList != null)
            for (TrieNode eachChild : childList)
                if (eachChild.content == c)
                    return eachChild;
        return null;
    }
}

class Solution5 {
    public static Node root = null;
    public static ArrayList<ArrayList<String>> ans;

    public static void deleteKey(TrieNode root, char[] key) {
        //add code here.
        TrieNode curr = root;
        boolean flag = true;
        for (char ch : key) {
            if (curr.subNode(ch) != null)
                curr = curr.subNode(ch);
            else {
                flag = false;
                break;
            }
        }
        if (flag && curr.count > 0)
            curr.count = 0;
    }

    public static void insert(String key) {
        Node curr = root;
        for (char ch : key.toCharArray()) {
            curr.map.putIfAbsent(ch, new Node());
            curr = curr.map.get(ch);
            curr.data.add(key);
        }
        curr.eow = true;
    }

    static ArrayList<ArrayList<String>> displayContacts(int n,
                                                        String contact[], String s) {
        // code here
        root = new Node();
        ans = new ArrayList<>();
//        HashSet<String> set = new HashSet<>();
//
//        for (String st : contact) {
//            set.add(st);
//        }
        Arrays.sort(contact, Comparator.naturalOrder());
        for (String str : contact) {
            insert(str);
        }

        for (int i = 0; i < s.length(); i++) {
            String prefix = s.substring(0, i + 1);
            Node curr = root;
            for (int j = 0; j < prefix.length(); j++) {
                char ch = prefix.charAt(j);

                if (curr.map.containsKey(ch) && j == prefix.length() - 1) {
                    curr.data.sort(Comparator.naturalOrder());
                    ans.add(curr.data);
                } else {
                    ArrayList<String> temp = new ArrayList<>();
                    temp.add("0");
                    ans.add(temp);
                    break;
                }
                curr = curr.map.get(ch);
            }
        }

        return ans;
    }

    private String addString(String s, String t) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        int j = t.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += s.charAt(i--) - '0';
            if (j >= 0) sum += t.charAt(j--) - '0';
            int rem = sum % 10;
            carry = sum / 10;
            sb.append(rem);
        }
        return sb.reverse().toString();
    }

    private boolean check(String s, int start, int len1, int len2, int n) {
        String s1 = s.substring(start, start + len1);
        String s2 = s.substring(start + len1, start + len1 + len2);
        String s3 = addString(s1, s2);
        int len3 = s3.length();
        if (n - start - len1 - len2 < len3) return false;
        if (s3.equals(s.substring(start + len1 + len2, start + len1 + len2 + len3))) {
            if (start + len1 + len2 + len3 == n) return true;
            return check(s, start + len1, len2, len3, n);
        }
        return false;
    }

    public int isSumString(String S) {
        int n = S.length();
        for (int i = 1; i < n; i++) {
            for (int j = 1; i + j < n; j++) {
                if (check(S, 0, i, j, n)) return 1;
            }
        }
        return 0;
    }

    static class Node {
        Map<Character, Node> map;
        boolean eow;
        ArrayList<String> data;

        public Node() {
            map = new HashMap<>();
            data = new ArrayList<>();
            eow = false;
        }
    }
}






