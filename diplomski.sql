-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 26, 2019 at 09:14 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `diplomski`
--

-- --------------------------------------------------------

--
-- Table structure for table `dogadjaji`
--

CREATE TABLE `dogadjaji` (
  `id_dogadjaj` int(11) NOT NULL,
  `naslov` varchar(256) NOT NULL,
  `tekst` text NOT NULL,
  `kategorija` int(11) NOT NULL,
  `mesto` int(11) NOT NULL,
  `ulica` int(11) NOT NULL,
  `uzrast` int(11) NOT NULL,
  `datum_dogadjaja` datetime NOT NULL,
  `datum_kreiranja` datetime NOT NULL,
  `korisnicko_ime` varchar(50) NOT NULL,
  `datum_isticanja` datetime NOT NULL,
  `thumbnail` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dogadjaji`
--

INSERT INTO `dogadjaji` (`id_dogadjaj`, `naslov`, `tekst`, `kategorija`, `mesto`, `ulica`, `uzrast`, `datum_dogadjaja`, `datum_kreiranja`, `korisnicko_ime`, `datum_isticanja`, `thumbnail`) VALUES
(1, 'Povratak korenima: Back to Funk u klubu BitefArtCafe', '<p>BitefArtCafe vas poziva na potpuno novi koncept žurki Back To Funk koji će se prvi put održati ovog petka, 25. januara.</p><p>Funk hitove izvodiće uživo James Brown Belgrade Tribute bend, dok će hitove sa ploča vrteti najpopularniji beogradski funky DJ Stefan Novović – DJ Iron.</p><p>Ukoliko ste se uželeli pravih igranki, đuskanja uz najveće soul i funk hitove, ovo je prava vest za vas.</p><p>Beograd je oduvek bio mesto raznolikog noćnog provoda, gde možete da pronađete za svakoga po nešto, reklo bi se – „od Silvane do Nirvane“. Ali, poslednjih godina muzički spektar se sve više deli na dve opcije – veliki broj kafana sa narodnom muzikom sa jedne strane, i veliki broj klubova sa elektronskom muzikom sa druge.</p><p>U međuprostoru nalaze se pojedini lokali koji nude žive svirke domaćih i stranih pop-rock, house i dance hitova. Jedan od takvih klubova je BitefArtCafe koji je ove sezone pokrenuo tematske večeri posvećene <strong>oldschool</strong>, <strong>disco</strong> i <strong>funk</strong> muzici.</p>', 7, 8, 37, 9, '2019-01-25 23:00:00', '2019-01-24 02:47:20', 'etf_org', '2019-01-26 04:00:00', '1.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `karakteristike_prostora`
--

CREATE TABLE `karakteristike_prostora` (
  `id_dogadjaj` int(11) NOT NULL,
  `id_stavka` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `korisnici`
--

CREATE TABLE `korisnici` (
  `korisnicko_ime` varchar(50) NOT NULL,
  `lozinka` varchar(64) NOT NULL,
  `salt` varchar(16) NOT NULL,
  `tip` tinyint(1) NOT NULL,
  `odobren` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `korisnici`
--

INSERT INTO `korisnici` (`korisnicko_ime`, `lozinka`, `salt`, `tip`, `odobren`) VALUES
('etf_org', '6‚ćk`�·)Ťô×řX<c/B“ĂĄ;”·zÁĺš˛?™¬Ň^`ÎZÉrŐmÎ>ő„ŰŔs‡ÜCéŽÖmfş\'wo¤ý‡š', '›,i‘nřl5wüŽ©é¦', 2, 1),
('nina_org', 'ÂX7ßTśě$ZŘ‰&Ú@¬ĐµţĆL+>ŃÖ—´ţNÚ�?\0łě‹fŐBY"|XlUŢkMĘszżę	ŇÜB�', 'w»čPoW\r\\+®ŁŘěY·', 2, 1),
('ORCA', 'oB5h7/g)3�ţoÉ”ˇü“Ś2ü›ËbŘ5?u°ă«¬stě÷XŹćG!Ţ�ŮCŐ€Š~¤�˘úžľě\'.ů', '¨Ř­WŻLÔ;i¤ŚOG§', 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `oglasi`
--

CREATE TABLE `oglasi` (
  `id_oglas` int(11) NOT NULL,
  `naslov` varchar(256) NOT NULL,
  `tekst` text NOT NULL,
  `datum_kreiranja` datetime NOT NULL,
  `datum_isticanja` datetime NOT NULL,
  `korisnicko_ime` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `oglasi`
--

INSERT INTO `oglasi` (`id_oglas`, `naslov`, `tekst`, `datum_kreiranja`, `datum_isticanja`, `korisnicko_ime`) VALUES
(1, 'Java Junior Developer dasgfdsg fasg sgdas fgdhas fghdsa fghas fdghsfd asghd fasghd asgd fasgd fasghdfasghd fasghd fasgd fasghdas fh', '<p>dasdasdas dasd asgdasgd asgdasfgdasfdasg dasgf asgd asgdfasgdas fda ghsd fas gdas fdagsd asd gasdasddasd gas gda ghsd ghasdasdasdasd as das d asdas fgdasd asdas d gas gdd gasd fgasdsdasdasdas fhasdasdas das d adas</p>', '2019-01-26 01:59:05', '2019-01-31 23:59:59', 'etf_org');

-- --------------------------------------------------------

--
-- Table structure for table `organizacije`
--

CREATE TABLE `organizacije` (
  `korisnicko_ime` varchar(50) NOT NULL,
  `naziv` varchar(50) NOT NULL,
  `kontakt_osoba` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `tekst` text NOT NULL,
  `oblast_delovanja` int(11) NOT NULL,
  `web_adresa` varchar(50) DEFAULT NULL,
  `mesto` int(11) NOT NULL,
  `ulica` int(11) NOT NULL,
  `telefoni` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `organizacije`
--

INSERT INTO `organizacije` (`korisnicko_ime`, `naziv`, `kontakt_osoba`, `email`, `tekst`, `oblast_delovanja`, `web_adresa`, `mesto`, `ulica`, `telefoni`) VALUES
('etf_org', 'Elektrotehnički fakultet Univerziteta u Beogradu', 'Miloš Nalović', 'opsta_sluzba@etf.bg.ac.rs', 'Razvoj Elektrotehničkog fakulteta u bliskoj je vezi sa istorijom univerzitetskog obrazovanja u Srbiji. Prvo visokoškolsko predavanje iz oblasti elektrotehnike održano je davne 1894. Profesor Stevan Marković bio je prvi predavač i osnivač Elektrotehničke katedre Inženjerskog odeljenja Velike škole u Beogradu. Stevan Marković Samo četiri godine kasnije, profesor Marković je osnovao i elektroinženjersku laboratoriju. Od tada, elektrotehničke teme su se izučavale na Velikoj školi, a zatim i na beogradskom Univerzitetu koji je iz nje nastao 1905. Prve diplome dodeljene su 1922 godine.', 18, 'http://www.etf.bg.ac.rs', 8, 22, '0113226760, 0113226992'),
('nina_org', 'Ninina organizacija', 'Nina Grujić', 'ninaorg@gmail.com', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque imperdiet dui at magna hendrerit aliquet. Ut consectetur scelerisque orci, non faucibus nunc laoreet eget. Aenean condimentum nisl a tortor faucibus, non malesuada nisl rhoncus. Nam non bibendum est. Sed aliquam elit non mauris dapibus, eu vestibulum libero consectetur. Proin nec urna dui. Nulla sed nisi nec ex cursus vulputate interdum vel augue. Pellentesque suscipit faucibus lorem. Aenean ultricies a purus in bibendum. In id erat vitae augue posuere pharetra. Maecenas augue orci, scelerisque vestibulum nulla at, mattis rutrum massa. Curabitur maximus lorem ac eros hendrerit, in rutrum nisi suscipit. Sed nisl risus, ornare non est non, fringilla rhoncus magna. Praesent posuere fermentum orci, sit amet dapibus sem. Donec sodales, nunc sed placerat hendrerit, quam ante luctus felis, a commodo urna augue id justo.', 17, 'http://www.mojaorg.com', 8, 22, '0601844595'),
('ORCA', 'ORCA', 'Dragana Tar', 'info@orca.rs', 'ORCA je organizacija civilnog društva koja pomaže ljudima u Srbiji i na Zapadnom Balkanu da brinu o prirodi i dobrobiti životinja kako bi ostvarili lični, ekonomski i društveni razvoj.\n\nSvoju misiju ostvarujemo kroz javno zastupanje, istraživanje, obrazovanje i praćenje primene politika i propisa. Kroz javno zastupanje, utičemo na usvajanje boljih zakona, njihovo sprovođenje i promenu kulture društva u odnosu na prirodu i životinje.', 31, 'http://www.orca.rs', 8, 32, '0112438653');

-- --------------------------------------------------------

--
-- Table structure for table `sifarnici`
--

CREATE TABLE `sifarnici` (
  `id_sifarnik` int(11) NOT NULL,
  `naziv` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sifarnici`
--

INSERT INTO `sifarnici` (`id_sifarnik`, `naziv`) VALUES
(1, 'vesti'),
(2, 'dogadjaji'),
(3, 'mesta'),
(4, 'uzrast'),
(5, 'ulice'),
(6, 'oblasti_delovanja'),
(7, 'karakteristike_prostora');

-- --------------------------------------------------------

--
-- Table structure for table `stavke_sifarnika`
--

CREATE TABLE `stavke_sifarnika` (
  `id_stavka` int(11) NOT NULL,
  `id_sifarnik` int(11) NOT NULL,
  `naziv` varchar(50) NOT NULL,
  `ikonica` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `stavke_sifarnika`
--

INSERT INTO `stavke_sifarnika` (`id_stavka`, `id_sifarnik`, `naziv`, `ikonica`) VALUES
(1, 1, 'muzika', 'vinyl.png'),
(2, 1, 'film', 'movie.png'),
(3, 1, 'festivali', 'festival.png'),
(4, 1, 'pozorište', 'drama.png'),
(5, 1, 'izložbe', 'art.png'),
(6, 2, 'koncert', NULL),
(7, 2, 'Clubbing', NULL),
(8, 3, 'Beograd', NULL),
(9, 4, '18+', NULL),
(10, 2, 'festival', NULL),
(11, 2, 'projekcija', NULL),
(12, 2, 'sajam', NULL),
(13, 2, 'radionica', NULL),
(14, 2, 'predstava', NULL),
(15, 2, 'izložba', NULL),
(16, 3, 'Novi Sad', NULL),
(17, 6, 'Zaštita životne sredine', NULL),
(18, 6, 'Naučna istraživanja', NULL),
(19, 3, 'Kragujevac', NULL),
(20, 5, 'Cvijićeva 36', NULL),
(21, 3, 'Kraljevo', NULL),
(22, 5, 'Bulevar Kralja Aleksandra 73', NULL),
(23, 3, 'Subotica', NULL),
(24, 3, 'Valjevo', NULL),
(25, 5, 'Brace Srnic 51', NULL),
(26, 3, 'Negotin', NULL),
(27, 5, 'Batutova 13', NULL),
(28, 6, 'Računarstvo i informatika', NULL),
(29, 3, 'Smederevo', NULL),
(30, 5, 'Topolska 18', NULL),
(31, 6, 'Zaštita životinja', NULL),
(32, 5, 'Stjepana Filipovića 29', NULL),
(33, 7, 'Pet friendly', NULL),
(34, 7, 'Besplatan parking', NULL),
(35, 3, 'Paraćin', NULL),
(36, 5, 'Cvijićeva 29', NULL),
(37, 5, 'Mitropolita Petra 8', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `vesti`
--

CREATE TABLE `vesti` (
  `id_vest` int(11) NOT NULL,
  `korisnicko_ime` varchar(50) NOT NULL,
  `kategorija` int(11) NOT NULL,
  `naslov` varchar(256) NOT NULL,
  `tekst` text NOT NULL,
  `datum` datetime NOT NULL,
  `thumbnail` varchar(256) DEFAULT NULL,
  `arhivirana` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vesti`
--

INSERT INTO `vesti` (`id_vest`, `korisnicko_ime`, `kategorija`, `naslov`, `tekst`, `datum`, `thumbnail`, `arhivirana`) VALUES
(1, 'nina_org', 1, 'GO Novi Beograd: Besplatni novogodišnji paketići za decu', 'Za mališane uzrasta do 12 godina biće pripremljeni besplatni novogodišnji paketići koje će Opština Novi Beograd podeliti tokom novogodišnjih praznika.\r\n\r\nKao i godinama unazad, deca sa Novog Beograda koju roditelji prijave dobiće svoj besplatni paketić u, sada već dobro poznatoj, novogodišnjoj atmosferi koju opština Novi Beograd sa ponosom tradicionalno priređuje za najmlađe sugrađane.', '2018-11-27 12:00:00', '1.jpg', 0),
(2, 'nina_org', 2, 'Da umor ne pokvari sve', 'Rasprodaje i slave, praznici i specijalni zimski događaji, planovi za izlet i boravak na planini manje prijaju kad je umor koji osećate konstantan, a vi ne znate kako da ga se oslobodite.\r\n\r\nDa li vam se čini da drugi više uživaju, više se raduju, emituju mnogo pozitivne energije, dok se vi poslednjim atomima snage trudite da ne zaostanete, i ne pokažete koliko vam je sve teško pada? U izvesnim godinama umor je očekivan i toleriše se kao tema, ali u nekim drugim, mlađim, to ne bi trebalo da bude.', '2018-11-27 14:00:00', '2.jpg', 0),
(3, 'nina_org', 4, 'VIII Plesni susreti u DKCB', 'U subotu, 24. novembra, na sceni „Donka Špiček“ Dečjeg kulturnog centra Beograd počeće „Plesni susreti“ članova plesnih studija za decu i mlade sa teritorije Beograda.\r\n\r\nRevija baletskih i plesnih studija sastoji se od dva koncerta (11.00 i 15.00).\r\n\r\nPlesni susreti osnovani su 2015. godine sa idejom da se afirmiše dečje plesno stvaralaštvo, predstavi rad koreografa koji rade sa decom i omogući razmena iskustava među plesnim pedagozima.', '2018-11-27 21:00:00', '3.jpg', 0),
(4, 'nina_org', 1, 'Pre Beth Hart nastupiće Mr. Swagger, Pera Joe i Katarina Pejak', 'Jedna od najboljih bluz-rok pevačica današnjice Beth Hart nastupiće u Hali sportova a gosti na koncertu su Mr. Swagger, Pera Joe i Katarina Pejak.', '2018-11-27 18:24:00', '4.jpg', 0),
(5, 'nina_org', 5, 'IV Funk kongres u Beogradu', 'U subotu, 15. decembra od 20.00, na poslednjem spratu kule Ušće (Top Of The Hub) biće otvoren međunarodni IV Funk kongres u Beogradu.', '2018-11-27 20:16:00', '5.jpg', 0),
(6, 'nina_org', 1, 'SubBeerni centar: Zabranjeno pušenje ovog četvrtka', 'U četvrtak, 29. novembra od 20.00, Zabranjeno pušenje će održati veliki koncert u klubu Subbeerni centar u Cetinjskoj 15.\r\n\r\nTime će promovisati svoj novi, jedanaesti album „Šok i nevjerica“, koji je objavljen 31. oktobra i dostupan za preuzimanje na', '2018-11-28 10:00:00', '6.jpg', 0),
(7, 'nina_org', 1, 'Mando Diao – energija, vatra i strast u Beogradu!', 'U petak, 7. decembra od 20.00, švedska indi rok grupa Mando Diao nastupiće prvi put u Beogradu, u Hali sportova „Ranko Žeravica“.', '2018-11-28 13:00:00', '7.jpg', 0),
(8, 'nina_org', 1, 'Musicology: Keziah Jones sinoć oduvao publiku', 'Harizmatični pevač i gitarista poreklom iz Nigerije, Keziah Jones, nastupio je sinoć sa svojim bendom, 28. novembra, u sklopu koncertnog serijala Musicology.\r\n\r\nU prepunom klubu Novi Bitefartcafe, Keziah Jones je još jednom dokazao da su njegovi koncerti jedinstveno iskustvo i oduvao publiku energičnom svirkom i spontanim performansom. Ovo je bio prvi od dva koncerta, a Keziah će po drugi put nastupiti u petak, 30. novembra, na istom mestu.\r\n\r\nKarata za ovaj koncert je ostalo jako malo, pa bi trebalo požuriti do najbližeg prodajnog mesta Eventima ili DDtickets ili ulaznice kupiti preko njihovih sajtova.\r\n\r\nMeđu prvim pesmama na koncertu našla se „Kpafuca“, a publika je od samog starta prihvatila poziv na ples i ostatak koncerta provela pevajući i plešući u transu uz nigerijskog blufank princa.', '2018-12-02 02:29:00', '8.jpg', 0),
(9, 'nina_org', 1, 'Dom omladine Beograda: The Tiger Lillies', 'U ponedeljak, 3. decembra od 21.00, u Velikoj sali Doma omladine Beograda koncert će održati britanski kamerni kabare trio The Tiger Lillies.\r\n\r\nUlaznice su u pretprodaji po ceni od 1200 RSD, preko Eventim mreže.\r\n\r\nThe Tiger Lillies spada u one specijalne pojave na globalnoj muzičkoj sceni koje nikoga ne ostavljaju ravnodušnim – uglavnom ih zavolite za sva vremena onog časa kad se upoznate sa njihovim pesmama, u kojima žive i nekako preživljavaju svi gubitnici koje možete zamisliti.\r\n\r\nMornari, prosjaci, prostitutke, zelenaši i drugi džeparoši, nesrećni ljudi čije se sudbine umetnički opisuju i proživljaju u jednom vodvilju što kroz songove opisuje dno sveta, kao da je u pitanju najbolji dramski tekst.\r\n\r\nKombinujući elemente cirkuske i ciganske muzike, atmosferu predratnog Berlina, motive iz „Opere za 3 groša“ – sa savremenim temama, The Tiger Lilies su stvorili autentičan umetnički pristup na granici pozorišnog i muzičkog izraza, koji nema svog pandana na sceni.', '2018-12-02 06:00:00', '9.jpg', 0),
(10, 'nina_org', 1, 'Neviđena „Rok opera“ u Beogradu', 'Koncert koji je izazvao pažnju i za koji se traži karta više je „Rok opera“. Nešto što na sceni Sava centra i u Beogradu još nije viđeno…\r\n\r\nObilje koncertnih aktivnosti, karakteristično je za kraj godine. Publika u Beogradu svakodnevno može da bira kom će se muzičkom žanru prikloniti.\r\n\r\nUglavnom, na sceni su izvođači od kojih znamo šta nas očekuje. Međutim, o koncertu „Rok opera“ sigurno će se dugo pričati.\r\n\r\nDirigent i aranžer Fedor Vrtačnik uspeo je da osmisli program koji 27. novembra od 20.30, nikog neće ostaviti ravnodušnim. Više od 120 izvođača – novosadski Big Bend i članovi hora i opere Srpskog narodnog pozorišta, na sceni će izvesti 20 antologijskih rok hitova.\r\n\r\nOrganizatori su prezadovoljni, jer je publika u Beogradu i Srbiji prepoznala kvalitet ove muzičke priče. Svima koji su na samom početku mislili da je jedan ovakav projekat prevelik zalogaj, samo nekoliko dana pred koncert, jasno je da će ovo biti pravo osveženje u moru „već viđenih“ koncerata.\r\n\r\nKonačno će i publika u glavnom gradu čuti i videti zašto je ova kombinacija dva, naizgled nespojiva muzička pravca, opčinila publiku u Novom Sadu, Zrenjaninu, na Paliću i u Crnoj Gori, gde je koncertu na otvorenom prisustvovalo više od 3000 ljudi.', '2018-12-02 00:00:00', '10.jpg', 0),
(11, 'nina_org', 1, 'Parobrod: Starogradska muzika u savremenom aranžmanu', 'U petak, 23. novembra od 19.30, UK „Parobrod“ pokreće seriju akustičnih koncerata „Starogradska muzika – muzika Starog grada“ koju otvara bend On Tour.\r\n\r\nVeć narednog dana u subotu, 24. novembra od 19.00, seriju koncerata nastavlja Dukat Stray Dogg.\r\n\r\nU ovom ciklusu od deset koncerata nastupiće najbolji domaći autori akustične muzike i uz redovni autorski repertoar, specijalno dorćolskom komšiluku u čast, odsviraće po najmanje jedan hit starogradske muzike u sopstvenoj obradi.Za dž\r\n\r\nDirektor Ustanove kulture Starog grada Milutin Petrović komentarisao je projekat „Starogradska muzika – muzika Starog grada“:', '2018-12-02 00:16:00', '11.jpg', 0),
(12, 'nina_org', 1, 'Jesenji Odjeci Beogradskog Šopen festa: U slavu Poljske', 'Tradicionalni kulturni program Jesenji Odjeci 7. Beogradskog Šopen festa biće održan u ponedeljak, 26. novembra od 18.00, u sali Jevrejske opštine (Kralja Petra 71a).\r\n\r\nŠopen fest i Ambasada Poljske organizuju muzičko-poetsko veče sa pratećom istorijskom izložbom „Očevi nezavisnosti“.\r\n\r\nDela Betovena, Lista, Šopena i Paderevskog, izvešće pijanističke zvezde u usponu Lazar Torbica i Dragana Teparić.\r\n\r\nDevetnaestogodišnji pijanista iz Šapca, Lazar Torbica, student je druge godine Akademije umetnosti u Novom Sadu, u klasi renomirane pijanistkinje i prof. Rite Kinke. Dobitnik je više od 40 nagrada na domaćim i međunarodnim takmičenjima.\r\n\r\nPijanistkinja sa karijerom u usponu, Dragana Teparić diplomirala je i završila master studije na FMU. Dobitnici je najznačajnijih nagrada i laureat je takmičenja u zemlji i inostranstvu.\r\n\r\nKao gosti večeri, nastupiće studenti Departmana drame FSU, Đorđe Jovičić, Nađa Ristić i Lazar Tešić i govoriće poeziju poljskih pesnika. Koordinator poetskog programa je prof. Biljana Đurović.', '2018-12-02 00:15:00', '12.jpg', 0),
(13, 'nina_org', 1, 'SKC: Oleg Kirejev i džez 1960-tih', 'U petak, 30. novembra od 20.00, u Studentskom kulturnom centru nastupiće saksofonista Oleg Kirejev koji će predstaviti džez šezdesetih.\r\n\r\nTo je zlatni period super zvezda o kojima i do danas kruže legende. Velikani Čarli Parker i Džon Koltrejn su već izveli svoje muzičke revolucije i inicirali nove stilove; Majls Dejvis je već proglašen za velikog muzičara, a budući titani Kit Džeret i Čik Korija su započeli svoj uspon.\r\n\r\nNa desetine ogranaka, eksperimenti, eksplozija novih ideja… Šezdesete godine su ispunjene inspiracijom, slobodom i novim mislima. Kul džez, bosa-nova i, naravno, tradicionalni džez – sve to ćete moći da čujete na koncertu Olega Kirejeva i njegovog ansambla.\r\n\r\nOleg Kirejev je priznati saksofonista koji je izvanredno upoznat sa tom epohom i ne samo na rečima. Oleg je bio učenik samog Bada Šenka, poznatog predstavnika „west coast“ džeza.', '2018-12-02 05:00:00', '13.jpg', 0),
(14, 'nina_org', 1, 'Koncert: Neno Belan & Fiumens sviraju pesme Đavola', 'U četvrtak, 22. novembra od 21.00, u sali Amerikana Doma omladine Beograda Neno Belan & Fiumens sviraće pesme legendarne splitske grupe Đavoli.\r\n\r\n– To je poseban koncert koji ću posvetiti opusu moje nekadašnje grupe Đavoli. Taj format zovemo double retro show jer nas vraća u slatki zvuk šezdesetih. Neće to biti običan koncert nego pravi muzičko-scenski događaj – najavljuje Neno Belan.\r\n\r\nKoncert „Neno Belan & Fuimens sviraju pesme grupe Đavoli“ posvećen je jednoj od najvažnijih rok grupa na prostoru bivše Jugoslavije, jedinstvenoj i prepoznatljivoj po mešavini ranog rokenrola i tvista uz specifičan mediteranski ‘začin’ i razrađen imidž.\r\n\r\nNeno Belan & Fiumens uživo će proći kroz sva četiri studijska albuma Đavola objavljena od 1986. do 1998. godine: „Ljubav i moda“, „Halo Lulu 22“, „Ostani uz mene“ i „Space Twist“.', '2018-12-01 13:06:00', '14.jpg', 0),
(15, 'etf_org', 1, 'Nina Grujic', 'Zdravoooo\n<p>dasbdsadbhdbahdbash <strong>ashdasjdhas </strong>dashbdasjhdba adsjdhasbdjha dasjhd ashd a ad asbd abdasnd ajshd asjd as dasnd asjd ah dasd asmd ajhdajhsdb</p>\n<p><u>dgash asgdas h sgdas gdjshad gahsd gashjdg asjhdgashd gasjhdgas dyasg djhasgd hasjdg jhdasgjd ashjdg ashdgashd as gdajhdgasdghasgd asjhjas </u></p>\n<ol>\n <li><u>dasdasda</u></li>\n <li><em><u>dasdasdsa</u></em></li>\n <li><u>dasdasd</u></li>\n</ol>', '2019-01-26 02:55:40', NULL, 0),
(16, 'etf_org', 1, 'dsdaas', '<p>&lt;script&gt;</p>\n<p>alert("HELLOOOOO");</p>\n<p>&lt;/script&gt;</p>', '2019-01-26 02:56:53', NULL, 0),
(17, 'etf_org', 1, '5', 'dasdasdasdas\n<p>dasdasdasdasd asdfasd <strong>fasd </strong>fad fasgdf asgdas fghd <em>fasgdfasghdf </em>asgd fasghd <u>fashdfasghd </u>fasgd fasghd fasgdfash</p>', '2019-01-26 03:14:31', NULL, 0),
(18, 'etf_org', 1, '4', '<h1>dadassasdas</h1>\n<h2>dasdasdasasas</h2>\n<h3>dasdasdasdasdasa</h3>\n<p>dasdasdassdasdasdas <strong>ashgdahjd </strong>gajhd <em>gashd </em>gashd gashd <u>gasdjhga </u>shd gashd gasjhdgashd asghd <a href="http://www.facebook.com" rel="nofollow">gashjd </a>gas</p>\n<ol>\n <li>dasdasdasasd</li>\n <li>dadasds</li>\n <li>dasd</li>\n</ol>\n<ul>\n <li>dasdasdadas</li>\n <li>dasdasdda</li>\n <li>sdasdadadasda</li>\n <li>dasdasadsasd</li>\n</ul>', '2019-01-26 03:21:56', NULL, 0),
(21, 'etf_org', 3, '1', '<p><strong><em><u>dgsd asghas fghds afdghas fdasgh fdshg dfasgd fasghdfasgd afsdgas fghdasf dgas fd ghasfdgas dfasghd fasgdfshgdfasgd fasgd fashgdfasghdfasghdfsghd fasgd fasghdf asghd fasghdafdgasfdgasfdgas dfagsdfasg hdfasgd fasghd fasdghas fdghas fdgahs dfasghd fasghd fasdgh fasdghfasgdfasgdhas fdghas fdgas fdghas fhdgfas dghasfdgasd fasdfas ghdfasgd asfgdh asfghd asghd asfdg asg</u></em></strong></p>', '2019-01-26 03:55:16', NULL, 0),
(22, 'etf_org', 1, 'najnovija vest', '<p>asdsdsad adasdasd<u>as dasd asd asd asdasd asd asds d gshjdgasjd gas</u>hd gasjh</p>', '2019-01-26 04:19:25', NULL, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dogadjaji`
--
ALTER TABLE `dogadjaji`
  ADD PRIMARY KEY (`id_dogadjaj`),
  ADD KEY `mesto` (`mesto`),
  ADD KEY `kategorija` (`kategorija`),
  ADD KEY `uzrast` (`uzrast`),
  ADD KEY `korisnicko_ime` (`korisnicko_ime`),
  ADD KEY `ulica` (`ulica`);

--
-- Indexes for table `karakteristike_prostora`
--
ALTER TABLE `karakteristike_prostora`
  ADD PRIMARY KEY (`id_dogadjaj`,`id_stavka`),
  ADD KEY `FK_karakteristika_stavka` (`id_stavka`);

--
-- Indexes for table `korisnici`
--
ALTER TABLE `korisnici`
  ADD PRIMARY KEY (`korisnicko_ime`);

--
-- Indexes for table `oglasi`
--
ALTER TABLE `oglasi`
  ADD PRIMARY KEY (`id_oglas`),
  ADD KEY `korisnicko_ime` (`korisnicko_ime`);

--
-- Indexes for table `organizacije`
--
ALTER TABLE `organizacije`
  ADD PRIMARY KEY (`korisnicko_ime`),
  ADD KEY `oblast_delovanja` (`oblast_delovanja`),
  ADD KEY `mesto` (`mesto`),
  ADD KEY `ulica` (`ulica`);

--
-- Indexes for table `sifarnici`
--
ALTER TABLE `sifarnici`
  ADD PRIMARY KEY (`id_sifarnik`);

--
-- Indexes for table `stavke_sifarnika`
--
ALTER TABLE `stavke_sifarnika`
  ADD PRIMARY KEY (`id_stavka`),
  ADD KEY `id_sifarnik` (`id_sifarnik`);

--
-- Indexes for table `vesti`
--
ALTER TABLE `vesti`
  ADD PRIMARY KEY (`id_vest`),
  ADD KEY `kategorija` (`kategorija`),
  ADD KEY `korisnicko_ime` (`korisnicko_ime`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dogadjaji`
--
ALTER TABLE `dogadjaji`
  ADD CONSTRAINT `FK_autor_dogadjaj` FOREIGN KEY (`korisnicko_ime`) REFERENCES `korisnici` (`korisnicko_ime`),
  ADD CONSTRAINT `FK_kategorija_dogadjaj` FOREIGN KEY (`kategorija`) REFERENCES `stavke_sifarnika` (`id_stavka`),
  ADD CONSTRAINT `FK_mesto_dogadjaj` FOREIGN KEY (`mesto`) REFERENCES `stavke_sifarnika` (`id_stavka`),
  ADD CONSTRAINT `FK_ulica_dogadjaj` FOREIGN KEY (`ulica`) REFERENCES `stavke_sifarnika` (`id_stavka`),
  ADD CONSTRAINT `FK_uzrast_dogadjaj` FOREIGN KEY (`uzrast`) REFERENCES `stavke_sifarnika` (`id_stavka`);

--
-- Constraints for table `karakteristike_prostora`
--
ALTER TABLE `karakteristike_prostora`
  ADD CONSTRAINT `FK_karakteristika_dogadjaj` FOREIGN KEY (`id_dogadjaj`) REFERENCES `dogadjaji` (`id_dogadjaj`),
  ADD CONSTRAINT `FK_karakteristika_stavka` FOREIGN KEY (`id_stavka`) REFERENCES `stavke_sifarnika` (`id_stavka`);

--
-- Constraints for table `oglasi`
--
ALTER TABLE `oglasi`
  ADD CONSTRAINT `FK_autor_oglas` FOREIGN KEY (`korisnicko_ime`) REFERENCES `korisnici` (`korisnicko_ime`);

--
-- Constraints for table `organizacije`
--
ALTER TABLE `organizacije`
  ADD CONSTRAINT `FK_korisnik_organizacija` FOREIGN KEY (`korisnicko_ime`) REFERENCES `korisnici` (`korisnicko_ime`),
  ADD CONSTRAINT `FK_mesto_organizacija` FOREIGN KEY (`mesto`) REFERENCES `stavke_sifarnika` (`id_stavka`),
  ADD CONSTRAINT `FK_oblast_organizacija` FOREIGN KEY (`oblast_delovanja`) REFERENCES `stavke_sifarnika` (`id_stavka`),
  ADD CONSTRAINT `FK_ulica_organizacija` FOREIGN KEY (`ulica`) REFERENCES `stavke_sifarnika` (`id_stavka`);

--
-- Constraints for table `stavke_sifarnika`
--
ALTER TABLE `stavke_sifarnika`
  ADD CONSTRAINT `FK_sifarnik_stavka` FOREIGN KEY (`id_sifarnik`) REFERENCES `sifarnici` (`id_sifarnik`);

--
-- Constraints for table `vesti`
--
ALTER TABLE `vesti`
  ADD CONSTRAINT `FK_autor_vest` FOREIGN KEY (`korisnicko_ime`) REFERENCES `korisnici` (`korisnicko_ime`),
  ADD CONSTRAINT `FK_kategorija_vest` FOREIGN KEY (`kategorija`) REFERENCES `stavke_sifarnika` (`id_stavka`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
