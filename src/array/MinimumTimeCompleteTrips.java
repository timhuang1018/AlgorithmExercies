package array;

import java.util.Arrays;

public class MinimumTimeCompleteTrips {

    //find minumum time which  just complete total
    //can easily find it start from time 1 -> how many trips finish
    //and so on , then increment is too slow -> binary search
    public static long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long left = 1; //fastest time
        long right =  time[time.length - 1] * (long)totalTrips; //slowest

        while(left <= right){
            long mid = left + (right - left)/2;
            long count = 0;
            for(int busTime : time){
                count += mid / busTime;
            }

            if(count >= totalTrips){ //try make it smaller
                right = mid - 1;
            }else{ //can't satisfy, need more time
                left = mid + 1;
            }
        }
        System.out.println(left);
        return left;
    }

    public static void main(String[] args) {
//        System.out.println(minimumTime(new int[]{1,2,3},5));;
//        System.out.println(minimumTime(new int[]{39855,21385,86948,57163,24158,85790,95497,9931,31399,15301,30502,9864,90569,76768,76558,25520,53221,54640,8598,93891,4852,32387,44867,47670,23128,75389,1345,80398,7141,85691,7859,34310,39572,26067,5289,2419,88745,17092,19382,97383,47924,49297,61875,83213,78446,20280,54103,5988,44138,98014,70068,40629,27668,69614,767,5102,57281,30718,62090,15972,47390,63120,19020,65576,54451,49138,65253,379,6274,14216,15187,72954,79830,31466,31230,90752,60447,50697,87962,11451,50764,59808,36341,34429,71087,6581,12391,77643,12933,7137,34509,5801,86028,19317,76047,94089,42607,93285,96182,40840,36044,76758,62611,81428,19953,99042,85656,54793,18519,59842,37041,86847,92069,3686,88019,65548,18648,85377,32337,52900,50186,16249,50497,40560,21428,63332,99216,76787,88475,60156,46913,80376,6128,31210,88495,28433,38413,46739,63024,31847,40496,76772,97946,87168,32608,62915,9258,68803,33867,51499,78422,34867,74364,52692,56160,12929,33858,45198,47105,63150,87337,20771,46910,79891,65240,72491,58765,12556,82000,46603,65756,15984,68408,80746,44271,43609,63055,44217,84793,73038,84435,66985,33660,71274,74119,58943,95030,48574,47951,92411,25404,72308,95260,69459,67538,37644,77089,71171,19326,51340,52811,38565,35975,75018,94222,55782,84684,87610,55546,56284,36187,19355,21207,85354,78983,21530,71115,5615,27187,8139,3370,2675,85771,66589,47899,17279,26893,10780,9922,22760,38541,56248,13180,65114,26789,88890,19878,893,88663,74443,66676,92287,35534,95285,16545,76240,97213,76400,97425,69110,64859,7846,7993,23703,53348,5018,23435,30923,98323,55530,75041,69507,83970,86219,2072,54465,61531,32407,99855,9951,98802,14151,2895,38919,23179,59648,9817,24341,63264,28118,3043,49693,30012,1696,81811,47028,26343,80723,82104,95809,19624,80051,79964,84482,23501,33006,90186,63866,77239,72394,75975,51628,37442,524,76820,34008,51291,61626,8814,7855,72136,60281,8548,81160,38205,38083,86751,973,18026,84504,94010,33726,31430,80283,8760,35044,53788,57911,50590,51651,20742,21740,43212,38597,4276,53057,61341,34130,56360,77496,74023,36488,17428,59242,58833,70002,34051,13336,47845,93079,48945,37061,67211,24666,30821,7205,12123,33095,56858,45532,53741,92358,70696,51440,87327,95264,85021,6060,66143,39158,2871,51371,54836,83812,70438,57434,74254,94945,53789,32629,5425,92636,27794,88802,17271,24750,57549,67005,45561,32002,63135,68783,68605,4577,8368,87969,19087,49079,24298,62351,11237,60279,46038,69423,67427,90421,22604,5402,87244,75065,24851,39380,7686,37762,29866,19881,32849,95769,60676,5478,74470,36875,85225,98143,49626,12118,51122,51155,85061,60690,79850,55644,62341,39034,18771,35101,13713,8936,88526,17357,52025,22702,64522,74064,772,59440,46389,53041,83355,49540,5187,85665,81489,41511,54428,34987,13421,56149,75249,2230,1250,70895,73014,7460,43295,75050,49740,86249,45537,31821,5009,91598,87187,77297,67798,10275,72838,91227,50765,24313,75534,27147,90252,8806,71714,26634,31106,46978,98498,99294,66511,13187,77017,96401,65434,91893,2918,76939,70156,5714,97276,62548,94372,25140,26994,10589,58693,4403,20668,55365,2887,10857,28638,75156,48504,47220,7671,99588,44484,56987,77096,14070,3196,27967,68872,29849,43574,70392,95521,61815,18189,80089,80929,31216,32003,50896,17301,34661,62807,34147,63298,39092,30591,33443,27862,24766,97258,7283,67045,48347,11823,50915,57314,69846,4670,84247,35004,74606,57177,78738,8254,52025,20273,23478,241,92924,2878,89433,54318,80456,8893,76704,91566,62607,43556,87708,4827,88119,82040,68470,35958,64577,77092,13710,50485,63615,80222,13552,37575,33468,34606,85579,10119,79448,28196,8593,95875,6160,59533,52694,34714,51146,19399,66850,51622,3908,14941,49026,52867,2747,79299,12758,31195,72747,58291,60895,34168,37361,57659,51805,96689,61422,43035,12567,50868,75849,31675,53668,9587,39133,48817,87623,30541,44094,26738,57621,89215,79569,75418,79784,95726,75853,78920,90046,86674,4304,79347,97412,34243,65067,39238,29373,57514,50680,91055,46411,84329,34521,71917,53545,38642,23726,82170,25845,27349,12419,47473,32164,51539,12092,42776,86597,4852,54502,65192,34940,3155,78997,19660,26850,36324,4373,19604,67553,69411,72614,73479,80183,51826,25100,61365,59213,80701,50611,66700,82649,28082,56365,6913,51660,5395,43862,36838,39883,13915,1607,6816,26175,52517,25317,38730,93750,5765,74382,98362,2934,91613,74255,21110,3443,70848,13682,25921,2914,39240,72222,15859,10596,55826,10497,78851,96039,74331,44631,46016,14354,28440,88468,40021,23247,96897,86116,23041,10414,24904,96710,30895,22816,67774,69443,29657,64652,55112,4841,32307,89675,9232,25047,44262,47420,6880,50170,32055,22735,85010,92123,36905,83146,19922,92680,11713,40430,24385,76178,79917,57202,13389,60983,81460,96435,95295,36937,27733,74306,86038,44580,57507,72091,252,90700,22211,82082,3713,30220,35825,89327,28128,5519,19000,55406,32483,24262,86036,42570,47419,97082,22904,172,51049,81130,3958,17551,39795,74386,70309,34068,35330,84622,44567,26790,50669,97503,87826,6781,84169,79363,99155,22965,64421,44623,5475,37083,57933,88214,87697,33921,52974,8354,44265,64401,27745,59601,76448,81980,51334,61759,58749,72843,7308,84011,63258,59322,18495,9696,68844,44356,3486,78718,44482,59257,44920,87091,85634,90521,2072,87507,72336,37244,2346,16202,82456,40992,16468,17653,74588,90355,27030,22422,48831,39689,83263,25724,81136,35773,2999,23356,64319,92800,85340,28818,56177,86285,58838,88353,87392,57175,85551,6814,54860,34025,82979,93323,56722,84010,58679,81422,11613,88979,11084,39242,93914,98743,2373,19533,22061,43322,84553,69064,68239,64119,21879,55389,56287,73355,99543,45418,36861,23873,20357,62387,87837,78523,59598,55784,29700,74883,98758,40113,1136,38166,83919,70463,3768,90446,37235,79360,20506,79435,77617,50065,92734,68915,26033,32919,91137,36975,44094,77949,94849,88327,58335,23762,56660,20759,67153,22764,34735,61033,94859,93969,19383,75433,14128,63043,59176,36562,21599,56431,47176,59580,59021,20973,48664,2250,68786,16379,3573,99195,34130,93254,50222,30768,91756,70755,3448,21637,1534,86375,15981,81682,6177,90964,27464,73653,91914,74795,446,36757,48939,85622,32428,43676,30253,4341,60985,59566,2499,20462,34794,46714,61678,52754,25702,12980,19149,90075,74955,46334,56602,24741,22446,76807,71833,69365,78104,38283,30109,87624,4482,83085,49627,89603,17250,81864,51589,65837,26911,85484,14793,1416,40739,39248,72017,99344,37751,90,95457,9384,80777,94324,4365,68385,10479,37802,60694,68653,84143,27089,5090,15867,34813,91753,30275,95075,96737,29091,52705,33087,56841,46621,53846,60753,32879,91794,65618,22957,63265,37459,20409,53021,64194,53762,84716,74780,99638,80381,42389,71261,16981,1280,51682,62345,52626,55205,56675,1849,26183,21193,32061,28201,7717,25409,32546,78071,51477,48919,46196,80760,95672,33462,21511,16584,6511,53434,15326,75690,67721,59287,95251,21929,48892,45165,41653,78450,25188,21982,70467,4521,76096,71307,56225,47337,68119,19245,86911,66307,46481,5195,74458,69887,29034,60136,89108,908,11613,31348,80363,94277,92776,60350,63688,46823,20112,73652,32193,98328,72405,82055,36759,71830,47304,90751,98936,19026,13230,77903,51186,14796,76295,86972,62274,72372,89745,30280,92525,63298,17574,34749,34463,77786,44793,82320,70954,11521,8479,88807,8722,40094,453,53850,69381,50774,30067,82175,60105,3063,3408,60197,77674,53754,33520,84949,65458,9619,35114,97253,96305,52364,30804,97935,11076,45422,4003,33975,51052,5494,48736,92258,87285,35632,88708,81277,15288,59573,6900,65638,52455,56620,29780,90136,22066,60712,82001,27109,6389,97439,90635,86815,40681,16593,4423,53093,18176,34161,3310,12356,31329,35354,58168,18766,83337,33201,22863,68047,72702,67109,83164,62444,2247,59220,39166,45058,76571,3470,68244,11824,43691,17229,53803,9574,29781,6321,9305,29240,12330,47712,22623,13279,6338,44710,41247,70050,31237,5855,44080,11093,79264,64004,96094,66920,71886,86912,25001,2450,41821,82805,15119,96409,68995,47691,6949,35985,71328,99679,52692,46128,2525,40331,15243,92553,35860,16437,94935,63885,20299,74016,73097,71436,3680,25282,68241,65766,42443,68012,99721,50590,80655,55460,76325,84381,33344,55319,23688,89911,9302,74476,90985,18607,11213,83091,72426,87443,34072,67029,26402,64758,94215,57803,34492,53738,29942,631,76172,7216,98243,62828,65676,88171,94498,89580,8855,84449,4137,54297,10051,721,77039,57634,97795,62836,74793,75995,203,11338,93173,84737,58321,9321,58087,73059,66623,45414,53670,14187,71043,77409,8232,45989,24661,53041,41794,69853,43412,27077,74494,70562,67275,82292,74280,67676,68191,69105,98683,16593,85121,66876,78927,13657,5723,64756,97161,95780,96991,13584,29764,15060,63112,21559,3964,98889,50860,83357,66231,6767,47055,25873,79248,34413,78030,69887,3460,7052,25148,74557,99192,8744,26008,65277,25999,48440,49191,96814,50190,33888,81590,11118,14284,56600,6463,93449,43342,57594,429,14448,11402,72954,47593,74638,44693,96741,88734,77766,83279,43266,47983,50198,95894,55167,3723,36704,28960,17670,36809,86847,90655,59991,54143,32917,52556,72291,97595,64544,11728,79400,94296,33056,8729,63910,58950,47233,42286,80787,84991,39118,31214,43787,36945,50700,85195,49875,81140,81682,84909,38286,63601,71588,5155,72552,12631,45082,17068,60121,50137,76195,8953,84658,94134,82926,48616,4935,19054,32738,24148,88838,3978,90967,56940,74027,60910,93346,15130,38073,74860,38429,39606,22271,50123,42887,79771,38277,24115,92397,70180,96742,52979,27730,59647,47563,85241,8835,2239,81990,15840,16133,21276,27755,7125,25107,41071,59593,61009,40735,72832,1107,1311,59859,54611,93384,58511,90808,2026,9334,41267,7592,93108,30012,70787,75513,15563,59223,93479,90637,81008,29872,63353,12556,45019,25421,8548,74917,43701,76159,28654,71163,7886,20106,22345,94367,84920,29486,57681,16198,50542,18864,65970,98632,69504,80709,44898,48643,18714,62001,69651,20643,87686,86427,68062,71056,29695,69638,75618,22078,73164,20668,17601,26146,76897,32328,82276,50991,90789,46823,14665,90576,32928,94814,27007,16002,19823,16555,19573,21247,45361,3176,99794,53030,64367,70886,30655,79804,13421,37782,84602,16134,52,85066,65781,79516,80870,71604,38455,77071,39591,5519,48624,98938,32497,17557,48345,94027,65032,85636,90398,52402,80142,88134,31505,34021,43206,15720,20323,12873,71796,50037,15909,59650,73886,92588,94499,63472,91148,16995,26074,6277,77202,47307,46410,66128,4280,31647,50768,97155,97801,27860,53784,44991,83060,56355,24751,35434,82090,85019,26942,12441,84607,30937,40823,67155,59724,84501,37192,5896,75198,1409,53324,70886,61282,74409,36350,96382,87890,2126,48335,33165,42637,42940,53135,84249,93235,86872,29457,11511,690,82388,67222,78014,75871,27948,24612,87368,36167,66482,9075,5696,32855,27413,11603,20068,73829,55862,57874,36269,62148,74313,93084,53274,76582,63579,5281,81085,74591,79648,12744,53334,67387,62813,746,82593,8912,32039,82155,96260,87039,81413,26897,90831,79949,70577,90896,66548,56591,44800,81120,84335,85322,88304,79971,91788,72505,42701,80434,68229,33210,50249,11905,83107,7806,59366,1502,54070,1468,94768,71101,68771,83635,54248,86365,35020,87932,54773,42582,28517,16232,88848,31936,56107,14157,36084,86584,37272,77637,1343,33181,43117,36913,47822,9453,92803,23724,51079,24108,77598,19515,87718,78055,73217,49701,73115,28981,11213,56656,20395,52690,40843,15691,69490,42468,75991,35211,75665,6274,35112,68900,27496,3218,86547,93467,14806,66262,45961,6793,57275,52860,25926,80577,45600,78457,48512,19677,61249,84291,1856,83259,94734,10966,64269,18851,17263,39951,99800,45812,58163,13101,24760,91214,20797,3827,29604,6251,76537,59952,77396,36603,34234,50404,76623,3496,48373,48815,14284,87449,68479,10565,37357,3943,51348,59253,49812,24720,49353,53407,11726,46752,57793,72653,2248,32392,90234,69274,99177,5553,45840,81952,23608,50349,80662,11435,52428,39507,36889,6583,59121,1931,24447,59433,75180,83870,66916,80347,99430,97850,267,13112,78651,24844,74003,6109,89968,74415,63639,10236,13503,47747,7246,7669,80871,96663,39582,98654,94483,80315,49889,80193,21300,34566,4661,47091,17068,87024,45058,19904,12986,40498,2336,22497,80468,66356,53071,98187,53741,89439,90457,58548,21930,83980,82405,73960,48406,93518,89353,92256,40487,52129,52500,78389,7129,49102,36692,33445,16874,23374,49785,74350,75925,4013,4719,71558,31160,54538,81056,25968,72789,87139,43066,70301,21479,54145,31023,84135,42052,45574,78238,71683,37267,14637,71850,97319,93488,52645,58794,11247,72204,51679,80561,46952,51069,85629,64714,45868,95811,67570,18736,30650,90815,16686,90836,86987,72075,58552,74088,10742,21881,50187,63826,27343,42719,65735,3800,5408,82467,11676,84312,23971,48197,92194,33649,48738,62956,96705,51021,9409,68051,70618,66251,65311,28689,14151,66432,28736,54470,43756,30589,54347,41246,28063,78425,20508,6709,69156,23320,82214,24948,6660,78010,19294,68106,49395,41874,96911,48014,57908,67905,8785,56154,69146,37172,75099,2676,76438,46519,73151,61352,65158,18630,17888,70981,70959,74813,33477,18891,70457,76694,74648,17850,37239,85549,46209,20387,30554,77773,93316,75263,82074,2411,62272,69388,49923,80169,59733,65396,42426,14861,53487,50691,61619,45450,99849,93982,18044,25633,58817,71292,50250,30908,90202,69967,90841,52456,16258,89846,15437,66458,71794,39761,19513,44330,20300,67368,20859,25144,57877,28999,43526,27507,239,10313,5327,54086,96236,22976,34225,27582,90543,62876,5678,20914,55057,36024,2472,75279,83182,95838,72334,6088,33978,50096,72873,71341,19714,18407,93943,62359,11377,48342,7710,5192,78121,33283,27816,34208,29696,84198,64912,42136,14697,16133,18397,23803,67940,32772,41192,25655,57798,745,90675,28447,89757,30108,86436,92825,5525,80167,20970,89510,91353,40308,47940,70855,21708,26597,56856,37294,30022,92991,73175,57052,7117,47514,58299,80410,23046,38655,38202,96639,48642,86015,7495,17808,21035,16984,94969,1914,3452,22270,90227,34371,19388,59913,10640,13487,66139,47901,35317,10943,39334,21221,46691,80796,43192,30112,16305,45471,33907,96048,41013,44863,60345,7863,62112,76241,83484,93183,33734,10987,88468,45522,39065,40738,66590,20510,95231,43912,9818,61991,43513,51810,51805,93914,70139,23123,53956,19966,79616,42526,81898,84505,9831,28857,55992,46332,52862,56497,9786,32267,37521,91843,98203,69739,23032,16907,67334,89796,81570,48494,91946,5114,69665,67321,57391,92557,50724,8448,13829,17680,7815,67851,18323,5858,83641,80325,84397,56889,17792,67291,62805,96347,29019,92408,91739,86927,43805,15155,58775,80818,79514,72272,91700,74274,27303,84633,97941,6817,29425,75970,8327,13990,63715,19112,49649,18304,96517,89804,93261,62156,96985,99172,99010,83514,88054,63959,37733,77176,42489,99666,7965,42389,89145,19013,82683,96702,51448,28641,95123,32949,10177,85494,27680,39620,8966,57627,21874,8204,40349,18292,76274,88097,10883,680,88635,23624,49813,94518,74382,46117,91678,91235,85503,14876,94891,13884,95900,20776,92170,87548,81433,98067,34947,54373,4822,13341,17837,44163,8573,38805,72072,86785,22025,80253,34076,945,32973,96341,95448,18923,41581,72812,36928,1191,42061,39672,18012,93619,15047,20715,88444,29633,42746,77730,88904,30755,3691,45179,40533,3775,36920,8239,6692,37369,70856,41975,26917,28767,69424,72222,20731,13540,85327,60335,58586,38548,56928,50249,69968,72726,53146,6935,76428,46676,66832,65136,39431,69469,69817,37202,32381,88656,32573,80827,28526,53533,20528,81976,47642,66603,79669,46239,74178,41460,23167,82243,86214,77017,48968,61874,55609,58278,98788,70008,91852,58618,63511,16674,56533,78031,3339,18495,76062,68028,70710,24840,46808,50370,89404,56607,95573,84511,6789,78755,11220,93349,88656,94792,61118,30961,95477,73023,56251,48854,1405,8491,86851,95375,17836,89689,8601,22524,84153,86637,58809,13894,64090,57815,7933,77756,64342,68872,9288,7607,62888,51853,9705,23771,31878,29014,87440,3941,51049,17483,81672,61465,3004,5251,4517,65102,94972,98332,16211,93926,2089,27796,25750,86572,86753,18871,31238,12686,83357,36521,40810,57474,29932,3614,24601,58208,65998,65911,10957,86526,50658,37016,36620,24861,80734,88691,99605,48153,6061,63885,21838,45574,43486,9362,25635,40872,59983,3033,23250,22964,65665,18580,39198,64432,20361,61052,48068,84662,2754,5494,69590,74979,21908,67511,81341,83818,88047,359,63151,99958,76968,99668,85374,53428,32735,85398,87425,27458,37800,21180,93777,37747,85890,12812,24304,37427,42631,43002,11707,88662,74555,67849,1168,94311,93471,83946,73526,63355,54120,424,58167,48606,39857,20640,25601,79662,5878,74510,94608,89450,48136,63912,97775,14097,73101,29270,67309,33681,51101,23387,26887,32880,74521,45886,74868,89628,91214,90125,78368,28872,98890,62756,22769,80661,6969,49850,42887,12173,74473,84926,77450,13992,13906,48660,92444,32717,70745,59258,85515,28674,66467,74642,60754,25641,21195,15191,37164,29965,17059,63954,28307,86638,86247,5611,66428,33874,29216,10271,18255,67155,12489,86349,83556,49821,22782,53511,19547,6014,56397,89034,27799,91858,29187,25672,86317,38416,9124,83252,33426,5369,14580,73174,30724,86993,23419,5616,71668,1037,67334,46814,66241,75895,28259,13890,96558,63869,32997,60416,51443,36424,32904,3126,78194,87691,3336,71357,62571,37394,77482,83528,97262,67028,92806,1521,46570,3312,21804,55647,86058,62991,65023,5577,26766,16009,18589,55365,8224,54393,58197,61577,19075,69371,64515,82106,5487,33080,10134,1809,52139,78265,84080,3009,84538,26512,56250,68010,57249,29607,30398,76203,22006,47036,87295,87452,31808,27495,70439,70069,31301,25691,55702,53484,23098,75823,4173,84855,16372,35391,98415,45289,20518,41022,65017,10485,66234,98988,98588,20878,46132,4024,86880,97758,33623,41542,27451,86619,75189,35270,12915,38077,77620,82140,9530,13844,2565,76264,62364,6698,59138,36554,38588,50781,35415,81749,55943,89614,4889,21919,55833,23622,65451,68445,56837,60620,6487,17487,83277,26905,8868,39346,19325,71090,35988,70141,64961,26607,29060,40901,40228,49863,81678,88891,72435,44123,95758,62041,15664,32699,39760,16334,67719,58285,74417,7629,29789,23704,797,78416,12831,84581,68605,81656,27757,8731,74213,7981,99735,69307,51843,33982,52290,4677,64579,41254,95419,77090,48519,62388,7352,81693,33047,2991,75736,40833,99052,71689,78217,67843,86734,11502,27630,99585,80550,30015,19137,80895,67659,54396,35842,60646,49932,54139,54371,91790,96136,35159,4902,87330,55527,9938,44453,47694,86705,43101,88984,29924,14853,34411,90408,52177,28593,99696,24305,88680,73797,49774,27402,16297,73174,96328,64343,36287,54992,8948,36864,27373,42582,7941,78536,88914,57964,24057,27844,3428,14397,72091,63519,12005,11279,87800,20658,45951,48758,23572,59782,79375,21946,73327,20257,73315,17071,6314,26067,92455,73391,41883,88420,15679,83962,62616,49395,26464,30697,28477,67971,25289,60255,77676,72806,23722,21373,74739,60773,84689,15636,89914,99897,5271,59032,57000,68260,13349,96909,66651,13202,39650,67032,91429,72231,94058,33775,83152,24462,49705,34613,4979,96975,18623,54736,63774,17036,30561,14156,12768,55945,38089,62086,55811,59754,15955,53648,72101,67408,85961,65145,89934,1457,66424,99627,63983,17032,30780,30338,41630,2775,11255,1203,13724,29641,38069,44310,39423,31106,85595,35033,1462,44388,13088,84371,67861,51569,86704,54203,45616,38124,54934,28095,74415,11598,32181,99809,51334,93506,85461,71574,88426,28920,7355,78770,4470,86336,4452,59770,41824,92261,47349,46022,38831,64350,20111,95986,59236,97155,17798,69327,59716,65063,69647,72957,17303,91865,40972,49771,3248,49146,60107,44197,514,14567,10060,34777,14398,82656,3250,57723,80189,9791,99149,43443,77270,4125,22684,92216,8685,78608,27706,83089,85276,36780,25938,51785,60795,84668,93220,43284,6459,965,71214,90482,59897,35791,11349,99301,84149,39064,55437,30237,96353,64337,14510,10098,56153,32091,64350,54082,23321},1448315));;
        System.out.println(minimumTime(new int[]{35526,68271,53295,85312,98439,20401,12567,75537,13042,3015,17945,51706,8379,9020,68149,90591,69251,9417,78418,35804,36630,93100,14223,27099,65124,38701,93629,82300,78404,72046,35760,11057,60001,55960,96428,49527,87398,89804,45956,46031,48904,35592,66810,2777,75831,753,82438,19950,57812,24402,51134,20588,25909,80046,36073,71308,94062,89630,18090,93549,23207,66416,54285,76663,66441,79464,67201,93574,61759,54469,42206,15010,17893,61618,27951,90361,86666,82842,43701,21837,56027,53768,53220,56636,73170,13353,22393,44370,46178,39523,86692,60228,37866,38409,844,36175,62823,40866,71862,19182,73662,11399,26141,57640,19902,40962,25361,58833,51163,35488,5561,54750,84308,64353,64150,17552,69778,13564,6011,79167,56980,98308,83980,45116,56028,88225,1824,93699,89442,22404,5868,18700,44476,15869,1583,57636,28371,6270,66188,37726,76939,79238,59320,89811,66535,93128,21053,86603,90383,17679,95629,80276,62367,54714,81017,88434,81240,91915,14418,2251,50001,57081,56030,11941,83308,14990,37527,25793,96967,12902,36597,38487,10090,23757,18301,70951,76172,38409,12228,20382,16560,90106,43687,99248,33738,48726,65936,71531,66629,95433,59822,230,13699,21614,48847,3254,9417,28867,38889,64031,57498,83515,71619,95748,86437,40468,40175,1062,94502,96956,240,14265,77888,59298,27311,93953,99919,41606,52803,51401,64132,55876,85391,97101,56438,21074,79997,56815,92097,14090,85007,83914,19222,30752,41580,81193,82585,16509,86366,5654,48942,22998,73761,40595,73144,90131,29770,40487,58407,91217,86723,91291,76943,87736,16745,21252,71347,13605,51863,67662,951,42887,34961,71152,83517,14521,63450,49661,72650,31854,38506,14508,1837,99584,73991,19604,174,78776,34463,96369,16743,9341,27944,65679,70077,33227,52684,51832,91464,34239,50175,48925,9918,76944,22485,24469,74612,90584,21380,68789,65552,35330,58725,30035,88445,76097,90479,33509,21790,69282,33720,32661,92204,61463,69033,18774,40028,67322,63697,85469,42726,35207,13436,49118,27075,41241,12212,54741,31899,38764,19239,45927,79779,82559,69922,97988,64077,60899,19250,33197,12227,55129,6161,7679,90383,21720,38419,59921,40394,22248,84651,9919,14769,50547,35590,22054,98547,92300,50533,24494,6357,74340,16444,36562,25519,70299,91085,58473,48549,7314,49789,50854,94732,16473,22298,94573,1177,16647,10489,40756,11864,52532,78056,72466,45909,83358,36728,61145,24085,19232,2698,5866,21763,19417,52766,70604,75357,86363,23548,59612,57256,72080,90665,62130,17811,11737,40209,76143,84341,62105,9559,15885,44428,65942,73923,60174,94085,85226,22423,11680,16007,72223,92611,24143,56415,99004,35300,63534,91796,95364,39871,39547,31533,9820,19254,80757,67351,61252,27802,9134,3264,6660,43279,74234,27708,92078,17050,92833,33868,28116,35816,23129,63684,21393,445,6655,50495,45718,86882,71493,7397,16595,77758,80091,780,3783,16168,55390,30565,34707,32019,85772,90904,96641,85382,61320,23459,6965,97895,19435,36616,9787,54886,90036,92125,34729,38960,66245,58496,96129,46772,73733,65067,53184,66181,58382,3922,5387,65890,77429,38183,84541,27072,90736,94570,99936,73272,60375,10952,9332,97636,39694,13399,51220,5018,36268,85523,34753,53991,56651,17209,7006,45423,49624,9709,18987,4592,30361,88433,48024,29942,91592,8239,28732,35824,4946,65484,16979,33142,75656,3209,22468,85755,39194,87907,72594,43707,36876,81362,15459,68075,19741,18928,44027,63719,21262,75445,30250,51196,6219,34048,23502,60665,1631,62306,23264,67398,49274,84972,16739,94834,23334,82672,92166,31032,78520,93931,28044,61781,76557,33376,46480,26749,22509,64281,54589,50426,44636,45225,99895,71585,17673,13409,95493,90636,86268,16980,7514,39203,9907,27569,14822,61552,41838,74638,87542,72644,13042,1869,96037,96075,126,74862,40225,59462,42920,58159,34863,72917,85179,48285,19993,84466,7840,5972,54264,43475,92314,4800,19150,69554,56691,19948,27419,59213,66373,44592,46195,82009,78601,17154,27595,95329,36216,91618,71112,10493,57289,30769,54429,1855,13489,74406,57880,3088,92345,10824,87602,94317,95410,79507,89423,60715,37526,53564,98388,48032,35013,60838,99317,30389,69656,32224,70212,53067,31487,77619,32138,56939,25282,66232,54525,51762,86251,15422,96128,59093,39155,91664,95086,64328,58154,16901,57839,36992,59934,61257,5557,15425,57045,12889,69846,29139,61557,83756,32458,90919,52963,14359,49874,80682,84655,65452,55068,43914,76328,45679,35127,72774,62715,91798,29872,81354,80582,96103,28903,50678,9125,45643,11868,9791,46321,41872,7001,92742,89046,77778,58288,57737,28006,38887,4145,30995,23181,22663,76976,12037,94311,69665,47087,243,85775,33414,14113,25750,68464,27502,33912,49055,86698,68094,7608,70775,62943,42776,34704,11471,4417,99359,60717,71140,87687,24846,22480,56390,47598,28920,1425,78664,65311,25188,69310,46708,56404,79811,22070,75607,32708,1979,67357,81800,28625,58021,29588,49578,16281,18081,74281,57898,39302,18506,70543,41031,35986,1699,96223,41042,13283,50709,61933,91181,46030,61266,66703,82807,89387,67547,6497,55088,61583,42425,91409,85463,8301,78781,80870,98576,55880,33799,9806,31789,1220,49041,40852,98197,88459,80809,30683,45742,53320,25920,65231,56346,207,17794,82843,50215,57,47903,10075,62437,2278,98786,98119,45948,30820,29230,1929,76287,79090,85711,72527,92053,26601,48647,76929,14214,44902,76505,40038,64918,60383,35546,2544,40358,86056,60688,18499,88770,22849,63307,51149,60424,47592,43259,26180,16534,49804,23756,9616,13388,64930,99325,39424,70127,92799,91793,28812,71828,14453,91106,666,62810,11290,9647,22966,16230,35343,84054,34513,2255,89433,26782,46009,53791,44813,68657,49581,41018,86354,2203,96565,76773,2292,20466,91806,21150,4547,34076,35288,17350,37117,89318,5010,41980,98619,34277,56047,96091,14986,47946,557,12310,45083,33215,41672,76247,22120,98394,52505,32913,13669,79991,50390,84603,96700,45380,83969,62960,922,77322,89247,22082,77155,58180,85090,34045,78015,83134,65175,12575,29973,33374,66596,9773,3090,5978,51347,10092,21711,12959,59636,66040,79673,11149,3982,70175,26604,19115,27400,34364,82326,23104,1413,72067,46839,39644,24885,60701,72571,46163,83030,62798,48657,10336,45398,31463,35149,93705,89614,55496,94724,47644,67168,252,67317,90167,73396,79355,42813,69604,60195,31448,38177,8685,3453,27967,34365,20916,31161,32697,13569,56538,97312,43741,20268,62417,8800,58889,887,59083,37770,54497,3483,13208,78264,63926,51702,57788,62339,34878,25061,9272,33436,11559,24844,55273,15700,86056,24847,59543,88362,88930,99160,76001,3727,24347,62899,15058,36773,22921,46114,25650,24349,54426,88951,56929,34112,35932,96915,20056,5065,11710,85022,4786,58819,86765,42917,16629,75041,9382,15583,19171,72488,45448,12527,50008,93346,80955,45643,28915,73390,67806,29676,21950,45132,98400,54683,46952,36276,47913,48498,1003,77209,65162,29328,77900,23452,46557,11635,60276,59815,55051,47365,40098,9110,42438,89515,29366,57827,77546,87805,52271,13786,13027,80350,11753,39876,30041,90876,79402,47918,8267,44250,20405,2429,47678,66426,74651,60939,19540,75226,69460,30180,2743,70832,70474,56895,35632,7563,40387,84892,72994,86326,76410,12579,85154,21588,97138,35456,10816,66345,77797,68559,33827,77916,36264,33517,73029,83578,19096,40231,15099,56610,75386,1213,72113,89289,50868,23025,47995,10864,37206,21100,77996,15471,34319,91648,20577,67231,99970,74615,67606,25690,35923,8601,25104,31088,79805,51973,51920,84434,80312,25120,69047,95483,50715,29121,89649,46749,15222,93612,88422,86352,65066,62750,34466,64722,74346,74135,11801,17645,3812,92193,47185,34855,70969,43411,70828,3418,30992,16477,82597,55609,44222,41623,7218,28642,22624,12312,10349,65818,2864,88496,75385,1598,56445,37344,25697,2769,68254,46395,69019,20250,35393,16111,71962,44468,34732,99529,92395,1285,41002,50225,97701,69150,6999,14127,2882,34898,19302,44052,8041,47837,65291,432,46098,8936,28920,67179,54431,81597,56203,18857,65644,66000,87428,47819,22412,99383,69228,86157,14117,95023,86969,74639,58154,4275,52890,5310,70266,52189,37070,90901,25435,60438,67789,21700,82598,95286,97387,79924,44033,5780,47403,72271,65250,39131,22041,98251,60309,57013,1582,84467,1141,21623,85870,21842,59956,31760,89107,68510,15402,49597,57244,51077,73507,92790,33644,79234,31355,91673,35535,86931,62187,13454,66936,57556,90153,7256,19272,36508,16036,44137,87064,47269,91970,20794,3900,55674,49311,39261,84557,75459,97774,16230,91469,37598,17275,62318,1287,88218,69983,56343,52444,6720,58269,36530,79221,14821,35676,19580,97810,13112,60622,94837,44378,3430,61281,81910,42891,51976,76436,57016,11020,4864,8852,31660,17645,46208,82855,56127,72673,46038,12074,80563,36165,52039,74661,97768,52559,49274,82208,28035,37180,23005,19487,57510,5296,92608,41737,83942,8223,24798,83768,25029,88857,34888,52171,63133,16939,95122,31264,7006,56696,84238,60986,25622,22973,83335,3681,92009,97206,67773,68873,50397,51845,81226,34,39384,19872,14387,29151,9105,86972,20259,22695,99301,50232,29296,9107,4977,49045,9573,25400,3430,1614,39028,51323,45596,95033,96890,30501,88688,66127,99318,44462,92340,9747,11523,12154,69783,91358,57856,13847,34876,82518,39401,33473,71995,98328,14358,23599,42472,37601,3994,46517,25420,68254,15846,34201,31710,26821,58743,36653,43639,40035,24876,87497,77685,53880,3974,70156,56738,54862,57692,24496,78266,93074,85729,90402,62515,42192,71592,50427,95841,47190,56716,90355,48926,37564,85781,98003,17932,1316,47175,13691,21194,59404,17063,31943,57638,31343,10416,32230,48887,48681,57475,6488,2456,43990,14847,71078,90582,15894,14900,607,97226,35692,18656,5661,29793,86919,9172,74191,71616,98707,32106,3270,1638,56606,33251,47674,96531,83026,15337,7690,59357,76286,3004,9482,66018,21242,35495,13893,49569,85876,55793,33537,40872,44376,16546,70122,32100,21875,20678,99865,50303,44668,44693,91958,32585,72362,15100,80982,84922,19799,6281,71324,23553,84000,11537,9987,11989,78728,48801,22431,29136,55355,1210,8810,62511,73092,19364,33795,72116,21347,20963,65833,21516,60259,35150,89862,30110,12255,49310,62911,84699,50812,87484,51140,33180,23721,43102,87331,64485,38692,99280,82267,46525,65494,66608,8576,4325,62705,1264,73176,71662,60603,8940,72042,59565,56845,60963,84186,49349,93269,52952,36143,53723,71740,74724,231,22097,38663,9335,43925,2581,62739,98742,42033,79802,79244,90414,16019,45066,39148,60390,30395,97585,2146,83533,33083,21610,49350,52022,11136,80338,37984,48941,1418,15299,83744,77547,23283,17848,15580,96413,90652,55304,80543,90444,39736,25184,97581,83751,2637,31870,36141,56952,30820,53485,39300,86380,83260,5938,8041,31166,81747,90246,59005,17518,37891,76974,55195,12518,76752,26574,65172,91410,65445,25579,92653,6594,60094,9417,12545,59743,62055,98462,9600,29863,67981,67879,46846,7392,98745,70390,4095,5956,36155,68863,90195,95964,77112,28063,90134,52560,93874,49959,42027,9440,34752,52771,19849,87997,87379,63548,59569,52334,62692,5080,40490,91007,48117,37029,94759,77285,39529,1649,76416,5543,10795,92415,34982,93706,21511,34713,39388,93102,26664,72093,91344,48561,65561,15644,4333,88512,69922,628,30835,99378,48424,50653,73012,1566,32326,33500,19250,87475,30050,19891,9056,59796,34813,54197,50608,20856,65886,4488,76521,1152,18755,61160,48431,12204,97447,76459,49690,97698,70421,99048,44070,73817,68521,62422,7982,16182,16317,39559,71648,86796,72009,38687,7436,50020,98498,45169,93147,22197,43132,61129,88097,71996,89492,78939,63460,13205,47621,59854,93737,13692,54880,36641,91097,34018,13116,85272,16665,64136,54215,86626,1344,43285,25293,79496,65273,54408,77274,39154,3993,15335,51165,22634,97282,29729,83357,54438,2147,70104,19345,33103,2427,79886,134,25065,88081,27753,35797,65751,54901,20082,15923,92378,43940,52952,41531,80001,94902,95656,36848,67464,42468,9211,80210,37793,15925,42715,13213,79743,17011,61664,43421,33152,3001,8827,46763,10915,28257,4300,74589,89336,31085,57587,24351,73466,43982,5703,22216,49434,67920,81581,8070,46878,53676,89532,84353,49629,5163,86758,67050,77195,45882,4109,57483,28697,55679,5357,8867,10287,62530,31985,46750,84278,40659,87414,98812,31866,61325,37999,72313,59255,73829,85009,94233,86222,88822,39680,51717,3151,66283,17161,54518,7700,7066,64517,6455,38964,55271,75958,28831,13335,78981,74682,93311,137,50773,19372,22942,66193,7933,75421,13298,10190,10491,28390,2349,93218,11645,64538,87658,15518,75241,82168,89629,86670,40543,50129,72279,19581,5069,97366,81016,38763,17769,24571,45101,97465,5993,38154,99649,74567,14153,21776,11101,36717,87277,99884,45629,47067,32780,48605,38675,85488,16652,56868,90644,96598,70106,82602,33629,39929,56605,87478,43391,93309,22052,79389,2886,11742,36552,60021,54743,24589,50454,53864,96536,38350,69221,94679,96750,26718,71884,91060,12596,81109,78873,92336,87173,90842,23954,63750,90190,55545,39966,58230,94228,9983,27601,73590,70753,19505,94838,68347,37238,94375,53468,26863,57021,26752,68456,45976,7388,55056,13700,66683,77694,18425,12599,88877,6592,62482,18514,82483,4059,49734,36353,63711,91839,29652,20495,80155,57275,89396,16259,97239,12774,73692,41461,12599,56618,4314,75868,38425,59913,48445,11992,54171,61090,77076,22021,90628,592,41149,59668,8392,73326,70286,39969,28559,90760,12728,22485,38024,56805,72248,62374,93814,56603,36766,20483,29108,69899,54716,92157,8007,68409,99130,83088,62064,144,57140,91156,44663,74510,28720,28887,95520,33241,13690,51013,66789,91294,39465,95469,49585,50342,16904,56808,53684,18149,21524,32434,7033,59557,18526,95720,80121,53717,65132,53858,3129,64755,24806,70014,94176,80436,71800,30134,33173,46264,26137,75713,28208,10992,77348,72817,40145,26088,21285,73042,66484,15626,21952,76775,42444,6457,63242,11260,54694,93444,51599,80659,71495,59436,91785,73158,67306,76508,91721,78035,54869,94827,4616,66911,35121,79145,3920,27705,6077,5951,22868,95675,31171,46438,16183,90960,28559,12650,89791,5334,56919,44770,17565,53393,11235,99655,22951,59332,78189,47541,50688,7868,20470,66262,81947,75386,26269,8458,86601,31819,74789,45359,59133,16555,25175,97976,4093,82424,17599,8592,44129,47207,98817,3993,81424,72002,14499,99665,27725,74553,30765,80152,55584,93326,96954,30835,15545,8739,20963,79883,3943,22904,53927,20392,28568,36203,24243,13634,30241,74395,32809,96123,64831,87880,65959,20690,72019,1078,1745,27088,88529,48743,72766,9200,20698,37956,32501,21765,5456,57915,85388,6353,48909,12211,66969,35961,271,66357,89455,91880,48750,12829,709,61938,25822,94229,28856,93512,59539,98099,17304,77838,44476,53337,34408,13134,52756,2460,82552,3181,79185,14560,53962,20638,91608,16060,83763,80765,71461,77105,1350,62806,533,1827,91473,38048,41104,59689,67601,77280,90046,13874,64463,22874,42209,35901,52004,3017,73522,37798,82560,41431,70841,72906,99966,74204,94450,97093,55200,63605,98097,28731,62612,21753,98228,93483,83959,47443,60507,68952,41553,28238,84748,87948,81648,48497,29304,92993,1250,62819,4916,36340,6264,62861,24981,72707,96637,13477,94568,79662,67125,13883,78906,47303,6845,85236,2548,36519,93614,79204,50412,61959,85700,4800,98600,28456,25639,66786,78043,41685,20649,48024,61669,45861,50920,81257,48988,61927,75672,4597,22160,52118,43704,46602,39978,87993,91268,59623,78492,80452,73226,15673,25000,91346,19411,31593,41439,32458,76626,83509,11734,15172,6204,91101,53806,56872,34644,86140,15379,99041,38954,9485,72746,35802,52522,43861,55246,71723,15138,73953,49241,80268,72534,51332,862,56139,29038,95060,87762,3537,36833,95134,43234,21821,50372,19963,14537,7743,99988,19814,10409,46316,94909,82056,34814,76070,14431,19808,9138,10107,72747,76360,64969,72420,57298,73337,1092,50757,82779,82283,81662,60064,44324,97633,18546,86655,13623,29278,18145,77557,55193,97046,16813,46822,17640,24407,1648,27760,46156,36317,9572,33885,17241,31190,72577,74632,34306,13532,82934,17653,90196,17569,1195,94533,1785,14079,53823,36039,38293,10499,25996,17919,17775,82137,61091,87037,54862,14250,86348,66202,29160,6857,82758,74672,31383,66637,36939,4434,78175,51977,94507,49712,77798,20749,12807,7605,27805,35523,46808,93285,18164,82679,94642,54265,42967,14329,60799,37518,89214,24196,46991,2246,10739,49335,63458,21711,70470,37318,10334,31199,20092,25850,98167,93952,19082,92091,94719,62500,11090,64723,56363,39439,64377,70009,61914,94347,98169,28996,32103,22804,78934,939,92408,66888,9870,38777,87901,72488,87911,24955,54019,52939,14843,74475,30004,48451,61505,56924,38228,25740,86307,33182,88115,42208,14926,43483,96176,94678,1372,69037,4418,54696,12865,18591,32249,61284,99269,82537,53923,75171,52963,82016,65938,6070,74983,82844,2031,13023,36900,65176,15851,42420,5611,34357,4229,62968,90842,65618,18943,72826,57326,9398,55950,57246,82142,69845,74193,17392,39558,3894,71351,17800,42863,38226,49762,83380,67348,98797,37393,49419,99379,22110,29993,18580,12621,6540,60437,82793,82963,70567,61916,88170,99020,42100,94015,71494,60055,28177,42828,41783,32945,7178,68743,87574,71950,19679,72667,8794,3496,47204,44998,44424,61927,12982,18249,83032,31449,14831,87554,60444,45411,25603,79296,35933,34591,48091,20148,91927,39965,2035,7913,66837,18925,82814,77992,12197,41227,18476,27648,92569,11478,82879,5618,3434,98822,95399,84697,71575,9661,97451,63312,54273,70919,28565,25086,39626,91069,22646,88443,45339,66406,54488,54367,45993,87062,23033,1536,7085,56507,15017,84041,94867,39256,81530,42457,18235,61187,54792,42708,25221,24433,39207,51027,13787,40006,2537,28987,86268,7351},9765277));
    }
}