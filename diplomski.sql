-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 28, 2019 at 05:32 PM
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
-- Table structure for table `admin_log`
--

CREATE TABLE `admin_log` (
  `id_log` int(11) NOT NULL,
  `tekst` varchar(256) NOT NULL,
  `datum` datetime NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `admin_log`
--

INSERT INTO `admin_log` (`id_log`, `tekst`, `datum`) VALUES
(1, 'Dodata stavka Muzika u šifarnik Kategorije vesti', '2019-04-17 16:54:41'),
(2, 'Dodata stavka Film u šifarnik Kategorije vesti', '2019-04-17 16:57:22'),
(3, 'Dodata stavka Pozorište u šifarnik Kategorije vesti', '2019-04-17 16:57:39'),
(4, 'Dodata stavka Umetnost u šifarnik Kategorije vesti', '2019-04-17 16:58:30'),
(5, 'Obrisana stavka Pozorište iz šifarnika Kategorije vesti', '2019-04-17 16:59:18'),
(6, 'Dodata stavka Književnost u šifarnik Kategorije vesti', '2019-04-17 16:59:51'),
(7, 'Dodata stavka Turizam u šifarnik Kategorije vesti', '2019-04-17 17:04:05'),
(8, 'Dodata stavka Koncerti u šifarnik Kategorije događaja', '2019-04-17 17:18:02'),
(9, 'Dodata stavka Clubbing u šifarnik Kategorije događaja', '2019-04-17 17:18:06'),
(10, 'Dodata stavka Festivali u šifarnik Kategorije događaja', '2019-04-17 17:18:25'),
(11, 'Dodata stavka Sajmovi u šifarnik Kategorije događaja', '2019-04-17 17:18:28'),
(12, 'Dodata stavka Radionice u šifarnik Kategorije događaja', '2019-04-17 17:18:53'),
(13, 'Dodata stavka Izložbe u šifarnik Kategorije događaja', '2019-04-17 17:19:28'),
(14, 'Dodata stavka Pozorišta u šifarnik Kategorije događaja', '2019-04-17 17:20:48'),
(15, 'Dodata stavka Bioskop u šifarnik Kategorije događaja', '2019-04-17 17:21:01'),
(16, 'Dodata stavka Beograd u šifarnik Mesta', '2019-04-17 17:21:09'),
(17, 'Dodata stavka Novi Sad u šifarnik Mesta', '2019-04-17 17:21:19'),
(18, 'Dodata stavka Kragujevac u šifarnik Mesta', '2019-04-17 17:21:24'),
(19, 'Dodata stavka Deca u šifarnik Uzrast', '2019-04-17 17:21:54'),
(20, 'Dodata stavka Odrasli u šifarnik Uzrast', '2019-04-17 17:22:03'),
(21, 'Obrisana stavka Deca iz šifarnika Uzrast', '2019-04-17 17:22:09'),
(22, 'Obrisana stavka Odrasli iz šifarnika Uzrast', '2019-04-17 17:22:11'),
(23, 'Dodata stavka Deca u šifarnik Uzrast', '2019-04-17 17:23:09'),
(24, 'Dodata stavka Tinejdžeri u šifarnik Uzrast', '2019-04-17 17:23:16'),
(25, 'Dodata stavka Odrasli u šifarnik Uzrast', '2019-04-17 17:23:20'),
(26, 'Dodata stavka Penzioneri u šifarnik Uzrast', '2019-04-17 17:25:24'),
(27, 'Dodata stavka WiFi u šifarnik Karakteristike prostora', '2019-04-17 17:25:40'),
(28, 'Dodata stavka Parking u šifarnik Karakteristike prostora', '2019-04-17 17:26:02'),
(29, 'Dodata stavka Pet friendly u šifarnik Karakteristike prostora', '2019-04-17 17:26:30'),
(30, 'Dodata stavka Prilagođeno invalidima u šifarnik Karakteristike prostora', '2019-04-17 17:26:53'),
(31, 'Odobren korisnik ticketVision', '2019-04-17 17:42:21'),
(32, 'Odobren korisnik TobOrg', '2019-04-17 17:49:30'),
(33, 'Odobren korisnik arsCreativa', '2019-04-17 18:03:10'),
(34, 'Odobren korisnik kisobran', '2019-04-17 18:03:12'),
(35, 'Izmenjen događaj Kišobran žurka – 10 godina // 01. avgust 2019. // Drugstore', '2019-04-17 18:41:38'),
(36, 'Izmenjen oglas Novinar/novinarka', '2019-04-17 19:09:35'),
(37, 'Izmenjen oglas Novinar/novinarka', '2019-04-17 19:09:44'),
(38, 'Dodata stavka nova kategorija u šifarnik Kategorije vesti', '2019-04-17 23:03:53'),
(39, 'Obrisana stavka nova kategorija iz šifarnika Kategorije vesti', '2019-04-17 23:04:21'),
(40, 'Kreirana anketa: Moja prva anketa', '2019-04-18 01:32:16'),
(41, 'Kreirana anketa: Moja druga anketa', '2019-04-18 01:35:05'),
(42, 'Kreirana anketa: test anketa', '2019-04-22 02:11:19'),
(43, 'Obrisana anketa Moja prva anketa', '2019-04-24 01:48:57'),
(44, 'Obrisana anketa Kisobran anketa', '2019-04-24 01:50:12'),
(45, 'Obrisana anketa test anketa', '2019-04-24 01:50:13'),
(46, 'Obrisana anketa Moja druga anketa', '2019-04-24 01:50:16'),
(47, 'Odobren korisnik test', '2019-04-24 02:04:36'),
(48, 'Kreirana anketa: anketa', '2019-04-24 02:07:10'),
(49, 'Obrisan korisnik test', '2019-04-24 02:07:59'),
(50, 'Obrisana anketa anketa', '2019-04-24 02:08:12'),
(51, 'Kreirana anketa: Ninina anketa', '2019-04-24 17:17:28'),
(52, 'Kreirana anketa: admin anketa', '2019-04-24 17:34:54'),
(53, 'Kreirana anketa: Jos malo gotovooo', '2019-04-24 17:35:20'),
(54, 'Obrisana anketa Jos malo gotovooo', '2019-04-24 17:46:57'),
(55, 'Obrisana anketa admin anketa', '2019-04-24 17:51:09'),
(56, 'Obrisana anketa Ninina anketa', '2019-04-24 17:52:40'),
(57, 'Kreirana anketa: sdad', '2019-04-24 17:56:45'),
(58, 'Kreirana anketa: anketa', '2019-04-24 17:57:02'),
(59, 'Obrisana anketa anketa', '2019-04-24 17:57:14'),
(60, 'Obrisana anketa sdad', '2019-04-24 17:57:15'),
(61, 'Kreirana anketa: Kisobran anketa', '2019-04-24 17:57:30'),
(62, 'Kreirana anketa: anketa', '2019-04-24 17:57:49'),
(63, 'Kreirana anketa: Kisobran anketa', '2019-04-24 17:58:06'),
(64, 'Kreirana anketa: admin anketa', '2019-04-24 17:58:27'),
(65, 'Kreirana anketa: Jos malo gotovooo', '2019-04-24 17:58:48'),
(66, 'Kreirana anketa: admin anketa', '2019-04-24 17:59:19'),
(67, 'Obrisana anketa admin anketa', '2019-04-24 17:59:24'),
(68, 'Obrisana anketa Kisobran anketa', '2019-04-24 17:59:31'),
(69, 'Obrisana anketa anketa', '2019-04-24 17:59:35'),
(70, 'Obrisana anketa admin anketa', '2019-04-24 17:59:36'),
(71, 'Obrisana anketa Jos malo gotovooo', '2019-04-24 17:59:37'),
(72, 'Obrisana anketa Kisobran anketa', '2019-04-24 17:59:38'),
(73, 'Kreirana anketa: Adminova anketa', '2019-04-24 21:01:57'),
(74, 'Kreirana anketa: Adminova anketa 2', '2019-04-24 21:02:31'),
(75, 'Kreirana anketa: Adminova anketa 3', '2019-04-24 21:02:52'),
(76, 'Kreirana anketa: Adminova anketa 4', '2019-04-24 21:03:30'),
(77, 'Kreirana anketa: Adminova anketa 5', '2019-04-24 21:03:56'),
(78, 'Kreirana anketa: anketica', '2019-04-24 21:06:58'),
(79, 'Popunjena anketa Anketa za korisnike', '2019-04-24 21:14:04'),
(80, 'Popunjena anketa Kisobran anketa za korisnike', '2019-04-24 21:14:15'),
(81, 'Popunjena anketa Kisobran anketa', '2019-04-24 21:14:21'),
(82, 'Obrisana anketa Kisobran anketa', '2019-04-24 21:14:35'),
(83, 'Obrisana anketa Kisobran anketa za korisnike', '2019-04-24 21:14:36'),
(84, 'Obrisana anketa Anketa za korisnike', '2019-04-24 21:14:38'),
(85, 'Obrisana anketa anketica', '2019-04-24 21:14:45'),
(86, 'Obrisana anketa Adminova anketa 3', '2019-04-24 21:14:47'),
(87, 'Obrisana anketa Adminova anketa 2', '2019-04-24 21:15:01'),
(88, 'Obrisana anketa Adminova anketa 4', '2019-04-24 21:15:02'),
(89, 'Obrisana anketa Adminova anketa 5', '2019-04-24 21:15:02'),
(90, 'Obrisana anketa Adminova anketa', '2019-04-24 21:15:03'),
(91, 'Arhivirana vest Nova vest od kisobrana', '2019-04-24 22:25:36'),
(92, 'Obrisana vest Nova vest od kisobrana', '2019-04-24 22:25:48'),
(93, 'Obrisan događaj Novi Dogadjaj', '2019-04-24 22:29:52'),
(94, 'Arhivirana vest Nova vest', '2019-04-24 22:31:57'),
(95, 'Obrisana vest Nova vest', '2019-04-24 22:32:00'),
(96, 'Obrisan oglas Novi oglas', '2019-04-24 22:32:58'),
(97, 'Obrisan događaj Novi Dogadjaj', '2019-04-24 22:34:43'),
(98, 'Arhivirana vest Nova vest', '2019-04-24 22:46:54'),
(99, 'Obrisana vest Nova vest', '2019-04-24 22:46:56'),
(100, 'Obrisan događaj Novi Dogadjaj', '2019-04-24 22:47:16'),
(101, 'Obrisan oglas Oglas 5', '2019-04-24 22:47:42'),
(102, 'Obrisan oglas Oglas 3', '2019-04-24 22:47:48'),
(103, 'Obrisan oglas Oglas 7', '2019-04-24 22:47:54'),
(104, 'Obrisan oglas Oglas 1', '2019-04-24 22:48:04'),
(105, 'Obrisan oglas Oglas 6', '2019-04-24 22:48:07'),
(106, 'Obrisan oglas Oglas 4', '2019-04-24 22:48:13'),
(107, 'Obrisan oglas Oglas 2', '2019-04-24 22:48:16'),
(108, 'Obrisana anketa Kisobran anketa', '2019-04-24 22:48:43'),
(109, 'Obrisana anketa Kisobran anketa', '2019-04-24 22:48:48'),
(110, 'Obrisana anketa Kisobran anketa', '2019-04-24 22:48:49'),
(111, 'Obrisana anketa Kisobran anketa', '2019-04-24 22:48:50'),
(112, 'Obrisana anketa Kisobran anketa', '2019-04-24 22:48:51'),
(113, 'Obrisana anketa Kisobran anketa', '2019-04-24 22:48:52'),
(114, 'Obrisan oglas test oglas', '2019-04-24 23:07:08'),
(115, 'Obrisana vest Test vest', '2019-04-24 23:10:25'),
(116, 'Obrisan događaj Test dogadjaj', '2019-04-24 23:10:34'),
(117, 'Obrisana anketa Kisobran anketa', '2019-04-25 01:19:25'),
(118, 'Popunjena anketa Najbolji Italijanski sladoled u Beogradu', '2019-04-25 01:53:00'),
(119, 'Popunjena anketa Popularnost kišobran žurki', '2019-04-25 01:53:29'),
(120, 'Popunjena anketa Bolje kišobran žurke', '2019-04-25 01:53:58'),
(121, 'Kreirana anketa: Kvalitet pretrage', '2019-04-25 01:57:26'),
(122, 'Kreirana anketa: Iskustvo sa administratorom', '2019-04-25 02:06:32'),
(123, 'Kreirana anketa: Korisnički interfejs portala', '2019-04-25 02:10:59'),
(124, 'Izmenjena vest Novi album: Kelly Clarkson – Stronger', '2019-04-26 20:26:29'),
(125, 'Izmenjen događaj Beogradska ultimativna kulturna akcija – Buka! Sada!', '2019-04-27 02:58:56'),
(126, 'Arhivirana vest Dan žena 2019: Besplatan ulaz u muzeje', '2019-04-27 04:02:12'),
(127, 'Izmenjen naziv organizacije arsCreativa', '2019-04-27 04:12:57'),
(128, 'Izmenjen naziv organizacije arsCreativa', '2019-04-27 04:13:00'),
(129, 'Odobren korisnik test', '2019-04-27 04:13:41'),
(130, 'Odbijen korisnik test', '2019-04-27 04:16:13');

-- --------------------------------------------------------

--
-- Table structure for table `ankete`
--

CREATE TABLE `ankete` (
  `id_anketa` int(11) NOT NULL,
  `kreator` varchar(50) NOT NULL,
  `naziv` varchar(256) NOT NULL,
  `opis` varchar(256) NOT NULL,
  `nivo_vidljivosti` int(11) NOT NULL,
  `datum_isticanja` datetime NOT NULL,
  `datum_kreiranja` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ankete`
--

INSERT INTO `ankete` (`id_anketa`, `kreator`, `naziv`, `opis`, `nivo_vidljivosti`, `datum_isticanja`, `datum_kreiranja`) VALUES
(1, 'kisobran', 'Bolje kišobran žurke', 'Pomozite nam da narednu kišobran žurku učinimo još energičnijom!', 1, '2019-05-17 23:59:59', '2019-04-25 01:31:49'),
(2, 'kisobran', 'Popularnost kišobran žurki', 'Pomozite nam da ocenimo popularnost kišobran žurki na društvenim mrežama!', 1, '2019-05-15 23:59:59', '2019-04-25 01:40:12'),
(3, 'TobOrg', 'Najbolji Italijanski sladoled u Beogradu', 'Rezultati ove ankete pokazaće gde se može pronaći najukusniji italijanski sladoled u Beogradu.', 1, '2019-05-10 23:59:59', '2019-04-25 01:47:17'),
(4, 'admin', 'Kvalitet pretrage', 'Pomozite nam da poboljšamo kvalitet pretrage na portalu.', 1, '2019-05-31 23:59:59', '2019-04-25 01:57:26'),
(5, 'admin', 'Iskustvo sa administratorom', 'Pomozite nam da ocenimo iskustvo korisnika sa administratorom portala.', 2, '2019-05-24 23:59:59', '2019-04-25 02:06:31'),
(6, 'admin', 'Korisnički interfejs portala', 'Pomozite nam da poboljšamo korisnički interfejs portala.', 2, '2019-05-18 23:59:59', '2019-04-25 02:10:59'),
(7, 'kisobran', 'Ocena sadržaja kišobran organizacije', 'Pomozite nam da unapredimo kvalitet sadržaja načih vesti i događaja.', 2, '2019-06-15 23:59:59', '2019-04-25 02:18:21');

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
  `thumbnail` varchar(256) DEFAULT NULL,
  `zahtev_brisanje` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dogadjaji`
--

INSERT INTO `dogadjaji` (`id_dogadjaj`, `naslov`, `tekst`, `kategorija`, `mesto`, `ulica`, `uzrast`, `datum_dogadjaja`, `datum_kreiranja`, `korisnicko_ime`, `datum_isticanja`, `thumbnail`, `zahtev_brisanje`) VALUES
(1, '16. Noć muzeja u Srbiji: Vudstok, Tuluz-Lotrek i Neispričane priče', '<p>Širom Srbije u brojnim gradovima i mestima, 18. maja 2019, biće održana nova muzejska avantura, 16. Noć muzeja.</p><p>Od 16.00 do ponoći posetioci će biti u prilici da zavire u muzejske kolekcije, otkriju galerijske priče i otvore vrata brojnih drugih, neretko i sasvim neočekivanih zdanja koja pričaju priču o slobodi.</p><p>Na tragu neprekidne umetničke borbe za slobodne prostore, ove Noći muzeja podsetićemo se na to koliko je sloboda dragocena.</p><h3>16. Noć muzeja u Beogradu…</h3><p>U Beogradu će tokom Noći muzeja publika moći da obiđe oko šezdeset lokacija širom grada, od kojih će mnoge svoja vrata za širu javnost otvoriti samo ove večeri.</p><p>Po svojoj ekskluzivnosti posebno se izdvaja tura „Neispričane priče“, koja se već tradicionalno realizuje. U okviru ove ture posetioci će moći da osete dašak slobode hipi ere i kultnog Vudstoka, biće u prilici da se upoznaju sa Beogradom iz vremena Kraljevine Jugoslavije, preispitaju sve što znaju o jedinstvenim spomenicima kulture – starim prestoničkim kafanama ili pak da uživaju u duhu slobode koji je obojio beogradski noćni život osamdesetih godina prošlog veka.</p><p>Kroz poigravanje sa sujevjerjima, običajima, lepotom i taštinom, posetioci Etnografskog muzeja moći će da istraže raskošni svet ogledala, preispitaju umetničke slobode na sceni Bitef teatar, a nešto drugačije putovanje iza kulisa prirediće i Fakultet muzičke umetnosti.</p>', 12, 15, 36, 19, '2019-04-27 17:00:00', '2019-04-17 18:30:47', 'arsCreativa', '2019-04-28 15:00:00', '932f0eee-503c-4abc-bbcb-0bf638795383.jpg', 0),
(2, 'BINA 2019 – 14. Beogradska internacionalna nedelja arhitekture', '<p>Od 9. do 30. maja u Beogradu, Novom Sadu i Pančevu biće održana 14. Beogradska internacionalna nedelja arhitekture – BINA 2019.</p><p>Tema manifestacije BINA 2019 pod sloganom „Pozitivno/Aktivno“, skreće pažnju na aktuelne i vanvremenske primere delovanja u urbanističko-arhitektonskoj praksi koje karakteriše pozitivan i proaktivan pristup razumevanju i rešavanju prostornih problema i pruža uvid u vrednosti, savremena tumačenja i naznake mogućih novih namena arhitekture nastale u periodu modernizma, viđena očima „Y“ generacije (milenijalci).</p><p>Kroz različite formate – izložbe, predavanja, filmove i instalacije BINA predstavlja savremenu arhitektonsku praksu koja nastaje u potpuno drugačijem društvenom, političkom i tehnološkom kontekstu, čije su osnovne karakteristike: brzina, diktat kapitala, fleksibilnost i transdisciplinarnost.</p><p>Kako biti profesionalan, ostvariti željene standarde, a istovremeno ostati veran etičkim postulatima struke teme su o kojima će se raspravljati na BINA 2019.</p><p><br></p><p><br></p><h3>BINA 2019 – šetnje, izložbe, predavanja…</h3><p>Program manifestacije je podeljen u pet programskih celina: BINA fokus, izložbe, predavanja i seminari, šetnje i izleti i radionice.</p><p>U <strong>BINA FOKUSU</strong> ove godine je stvaralaštvo i rad uvaženog arhitekte Aleksandra Stjepanovića.</p><p>U okviru ovog programa, na svečanom otvaranju manifestacije, u Artget galeriji Kulturnog centra Beograda, u četvrtak, 9. maja od 20.00, biće otvorena <strong>studijska izložba „Arhitektura Aleksandra Stjepanovića“</strong>, autora Jelice Jovanović, Relje Ivanić i Marka Kažića. U okviru ovog programa biće organizovana i predavanja i šetnja kroz objekte ovog značajnog arhitekte socijalističkih vremena.</p><p><strong>BINA izložbe</strong> koje se tradicionalno održavaju u Likovnoj galeriji Kulturnog centra Beograda i galeriji Artget, a ove godine i u galeriji FLU i Kolektiv, dolaze iz okruženja, Italije, Austrije i Slovenije.</p><p>U okviru gostujuće izložbe iz Južnog Tirola, Austrija, <strong>NEW TRADITION / NOVA TRADICIJA</strong>, predstaviće se sedam arhitektonskih studija i umetnika, a autori i kustosi projekta su David Kalas (arhitektura) i Liza Trokner (vizuelna umetnost).</p><p><strong>MODERNI U BEOGRADU (MuBGD)</strong> okuplja grupu arhitekata (Bekić Iva, Gajić Irena, Dukanac Dalia, Đorđević Stefan, Zlatković Snežana, Ješić Mirjana, Stojanović Hristina, Cigić Petar) sa posebnim interesovanjem i angažmanom u oblasti ilustracije, grafičkog dizajna i likovnih umetnosti.</p><p><strong>ARHITEKTONSKA NAGRADA PIRANEZI</strong>, Piranski dani arhitekture iz Slovenije predstavljaju se u galeriji Kolektiv. Prestižna međunarodna Piranezi nagrada iz oblasti arhitekture, dodeljuje se od 1989. godine i deo je međunarodne konferencije Piran Dani arhitekture (PDA). Nagrađuju se najbolje arhitektonske realizacije sagrađene u centralnoj Evropi u poslednje dve godine, a od 2008. godine takođe i najinovativnije studentske ideje. Fokus nagrade je na renomiranom odnosu savremene arhitekture u prirodnom, kulturnom i istorijskom kontekstu.</p><p><strong>PLASTIKA NEMA GRANICE</strong> je site-specific postavka arhitektonskog kolektiva BASURAMA, Španija, u saradnji sa galerijom Kolektiv, na Trgu Republike, i platou ispred Kulturnog centra Beograda. Basurama je umetnički kolektiv posvećen istraživanju, stvaranju u kulturi i prirodi i produkciji čija se praksa okreće oko odraza smeća, otpada i njihove ponovne upotrebe u svim njegovim oblicima i mogućim značenjima. Njihov cilj je da proučavaju te pojave svojstvene masovnoj proizvodnji realnog i virtuelnog smeća u potrošačkom društvu, pružajući različite tačke gledišta na ovu temu da bi generisati nove misli i stavove.</p><p><strong>ARHITEKTONSKI I URBANISTIČKI KONKURSI i ARHITEKTONSKE NAGRADE</strong> <strong>– sezona 2018-19</strong>, kao i izložba aktuelnih radova arhitektonskih studija URED i AKVS iz Beograda u okviru postavke PONESI SVOJ PROJEKAT, sastavni su deo programa BINA 2019.</p><p>U okviru programa izdvaja se programska celina <strong>SAVREMENA DANSKA ARHITEKTURA</strong>, u okviru koje će se posredstvom izložbe na otovrenom u Knez Mihailovoj ulici i niza predavanja predstaviti arhitektura zemlje koja je u samom vrhu savremene arhitektonske misli i produkcije.</p><p>Na tradicionalnom seminaru <strong>ARHITEKTI, PROJEKTANTI, PRAKTIČARI</strong> predstavljaju se učesnici iz Helsinkija i Beograda. Stogodišnjicu Bauhausa obeležiće predavanje <strong>ŽENE BAUHAUSA</strong>.</p><p><br></p><p><br></p><h3>BINA 2019 – šetnje</h3><p>Beogradska internacionalna nedelja arhitekture poznata je široj javnosti i po <strong>BINA šetnjama</strong> koje organizuje sa ciljem boljeg upoznavanja arhitekture grada Beograda.</p><p><strong>Besplatne tematske šetnje</strong> namenjene najširoj publici su uvek posećeni segment naše manifestacije, a ove godine će&nbsp;se obići zgrada PRIZAD-a (sadašnji Tanjug), Radio Beograd, Udružena banka, staro jezgro Zemuna i naselje Cerak-Vinogradi.</p><p>Pored već tradicionalnih šetnji kroz arhitekturu Beograda (Alejama Novog groblja, Jevrejsko nasleđe i Žene u arhitekturi)i ove godine planirana su <strong>dva izleta</strong>: u okviru izložbe posvećene Aleksandru Stjepanoviću – obilazak Filozofskog fakulteta u Novom Sadu, i izlet za Pančevo.</p><p>I ove godine BINA nastavlja sa projektom <strong>Gradovi deljenja</strong> (Shared Cities Creative Momentum – SCCM), u okviru kog unapređujemo život stanovnika prigradskih naselja, putem edukativnih radionica i kroz male intervencije u javnom prostoru (naselje Ledine).</p><p>SCCM je evropska kulturna platforma koja preispituje savremene urbane izazove evropskih gradova. Na ovogodišnjoj manifestaciji biće prezentovano Urbano čvorište 2 – Multifunkcionalni krug, letnju učionicu i mesto okupljanja. Projekat se realizuje u saradnji sa NVO Škogled i Osnovnom školom „Vlada Obradović Kameni“.</p>', 12, 16, 37, 20, '2019-05-09 00:00:00', '2019-04-17 18:33:48', 'arsCreativa', '2019-05-30 23:00:00', '301af7b9-b535-41ad-bfe2-e5f6c48d6a39.jpg', 0),
(3, 'KC „Čukarica“: 78 dana…', '<p>Kulturni centar „Čukarica“ je koncipirao i osmislio izuzetno sadržajan program „78 dana…“ povodom obeležavanja 20 godina od NATO bombardovanja.</p><p>Dvadesetogodišnjica NATO agresije na Saveznu Republiku Jugoslaviju, danas Srbiju biće obeležena izložbom fotografija „NATO agresija u 78 slika“, koja će biti otvorena 23. marta od 19.00.</p><p>Pored ciklusa od 20 predavanja „Živa reč za kolektivno pamćenje“ ova ustanova će štampati fotomonografiju „Dvadeseta godišnjica podsećanja na dane otpora, odbrane i stradanja: NATO agresija u 78 slika“.</p><p>Izložba se realizuje u saradnji sa istaknutim fotoreporterima tog vremena i sa osloncem na fototeku i autore kompanije „Novosti“.</p><p>Po zatvaranju izložbe, kompletna postavka se seli u druge gradove Srbije (Niš, Vranje, Kraljevo, Pančevo, Valjevo, Aleksinac, Prokuplje, Zaječar…) i Republike Srpske da bi na kraju, na simboličan način, bila predata u trajno vlasništvo Gardi Vojske Srbije.</p><p>Pošto se obeležava dvadeset godina od NATO agresije predviđen je i ciklus od 20 predavanja veoma kompententnih ličnosti: Živadin Jovanović, Darko Laketić, Momir Bulatović, Vladimir Lazarević, Milivoje Pavlović, Božidar Delić, Nikola Šainović, Vidoje Kovačević…</p><h3>Za 78 dana…</h3><p>Da se podsetimo…</p><ul><li>Tokom agresije izvršeno je oko 2.300 vazdušnih udara na više od hiljadu objekata širom zemlje.</li><li>Bilo je angažavano više od hiljadu borbenih aviona NATO snaga i lansirano više od 400.000 projektila, ukupne težine 22.000 tona.</li><li>Upotrebljeno je više od 1.300 krstarećih raketa ogromne razorne moći.</li><li>Iako je Ženevskom konvencijom zabranjena upotreba kasetnih bombi, izručeno ih je 37.000 za dejstvovanje po živim ciljevima. Samo od njih stradalo je više od 200 civila.</li><li>Tokom NATO agresije poginula su 462 vojnika i više od 2.000 civila, među kojima je bilo 88 dece, na desetine starih osoba i bolesnika na lečenju.</li></ul><p><br></p>', 12, 15, 38, 20, '2019-05-23 19:00:00', '2019-04-17 18:36:42', 'arsCreativa', '2019-05-31 19:00:00', '9f508a0b-48ab-4161-bd1e-d51cc195c291.jpg', 0),
(4, 'Kišobran žurka // 10. mart 2019. // Drugstore', '<p>Datum je 9. jun, lokacija je Dragstor, start od 23h, zezanje je beskonačno.</p><p>Tu su Disko Buvljak, Do the Math, X-Coast, DJ Flip, Summer Deaths, Spejs Noksi, Nihil, Milković i Yan Dusk.</p><p> Tu smo naravno i mi.</p><p>Karte u pretprodaji u Zaokretu (300rsd). Na ulazu 500. Dođi.</p><p>———-</p><p>Kišobran žurka</p><p> 09. Februar 2019. godine</p><p> Klub Drugstore, Bulevar Despota Stefana 115</p><p>Start: 23h</p><p> Big Room: Kišobran DJs</p><p> Black Room: X-Coast, DJ Flip, Do the Math</p><p> ICB: Disko Buvljak, Zicer Inc. showcase</p><p>Karte: 300 rsd u Zaokretu, 500rsd na ulazu na parti</p><p>———-</p><p>Godina samo što je počela, a mi već imamo spremne nove hitove na koje želimo da vidimo vaše reakcije. Neverovatno je koliko dobrih bendova najavljuje albume u narednom periodu, pa smo prilično sigurni da će 2019. biti godina vrhunskih izdanja.</p><p>X-Coast ima novi EP i dolazi u Beograd u okviru evropske turneje, a društvo mu prave DJ Flip i Do the Math iz Kišobrana koji će ovom prilikom imati ulogu domaćina.</p><p>Zicer Inc. za sebe kažu da su “oskudni hip hop kolektiv”, ali po nama su definitivno ekipa koja donosi novu svežinu na rep scenu. Ubeđeni smo da će 2019. biti godina u kojoj će njihov zvuk eksplodirati. Na čelu sa misterioznim producentom koji se krije iza imena Summer Deaths, ekipu čine Nihil, Milković koji ima hit singl Lisabon, Spejs Noksi i Yan Dusk koji su u decembru 2018. izbacili fantastične albume.</p>', 8, 39, 40, 19, '2019-03-10 23:00:00', '2019-04-17 18:39:45', 'kisobran', '2019-03-10 04:00:00', 'cd9b64d6-0514-4ca4-bc42-2be0307cfdfb.jpg', 0),
(5, 'Kišobran žurka – 10 godina // 01. avgust 2019. // Drugstore', '<p>Kišobran 1. decembra 2018. obeležava 10 godina postojanja i tim povodom pravimo veliku, do sada najveću žurku. Prijatelji sa svih meridijana alternativne scene nam se pridružuju u slavlju osvajajući sve poznate i neke do sada neiskorišćene prostorije Dragstora jer zezanje pravimo na čak 5 bina!</p><p>Pored Kišobran didžejeva koji pripremaju plejadu hitova koje su obeležili žurke u poslednjih 10 godina, u pomoć nam dolaze i njujorški producent Baltra, DJ Brka (Disco Not Disco), Stevie Whisper i Vitanov (YES), Vizelj, Lonče (Pop Depresija), Hidden BG, Kene Beri, Matej Rusmir i Andria (Insolence), Sergio Lounge, lelú, Miško Bilbija, Trifun &amp; Ivan Beloševac i nezaobilazni Disko Buvljak.</p><p>Čak ni Dragstor nije bio dovoljno veliki da uključimo sve ljude koje smo želeli, sve ljude sa kojima smo sarađivali i sve ljude sa kojima smo se družili za ovih 10 godina, ali će svi oni biti sa nama u masi, gde planiramo da slavimo do zore.</p><p>Kišobran kolektiv se tokom godina menjao, bio aktivan na mnogo polja, negde prednjačio, negde pomogao, negde samo podržavao prisustvom, ali jedna konstanta tokom godina uvek je bila Kišobran žurka – okosnica kolektiva i događaj na kome su se svima ukrštali putevi.</p><p>+++++++++++++++++++++++++++++++++++++++</p><p>Deseti rođendan Kišobrana</p><p>Subota, 01. decembar 2018. godine</p><p>Klub Dragstor, Bulevar Despota Stefana 115</p><p>Start: 23h</p><p>Big Room: Kišobran</p><p>Tech Room: Sergio Lounge, Vizelj, DJ Brka, Lonče, Miško Bilbija</p><p>Chambers: Stevie Whisper, Vitanov, Matej Rusmir, ANDRIA</p><p>Black Room: Baltra Baltra, HiddenBG, lelú</p><p>Ice Cream Booth: Disko Buvljak, kene beri, Trifun &amp; Ivan Beloševac</p><p>Prodaja karata u Zaokretu:</p><p>Jako ograničena količina prve ture karata od 03. novembra po ceni od 300 dinara</p><p>Standardna cena u pretprodaji 400 dinara</p><p>Cena karte na ulazu 500 dinara</p><p>+++++++++++++++++++++++++++++++++++++++++</p>', 8, 15, 40, 19, '2019-08-01 23:00:00', '2019-04-17 18:41:17', 'kisobran', '2019-08-02 04:00:00', '4e0bba1a-0ba4-44c0-9bf3-77e0de18628e.jpg', 0),
(6, 'Kišobran žurka // Subota 13. oktobar, 23h // Kc Grad', '<p>Jedna intimna pred veliko finale i 10. Kišobran rođendan</p><p>Ne postoji bolji osećaj nego kad žurka eksplodira, a vi ste nam da dohvat ruke pa skačemo, vrištimo i grlimo se zajedno. Ovog puta bez velikih bina, bez velikih obećanja, samo mi i vi, jedan podijum dok se ne raznesemo zajedno, pa ko preživi pričaće.</p><p>Subota 13. oktobar, Kc GRAD od 23h, karte u Zaokretu 300, na ulazu 400.</p><p>Vidimo se unutra!</p>', 8, 15, 41, 19, '2019-10-13 23:00:00', '2019-04-17 18:43:31', 'kisobran', '2019-10-14 04:00:00', 'ec1728c3-65d6-4bbd-9951-2d65df827cdf.jpg', 0),
(7, 'Musicology: Nik Vest', '<p>Američka fank basistkinja, pevačica i štićenica legendarnog Prinsa, <strong>Nik Vest</strong>, nastupiće <strong>26. marta</strong> u Bitefartcafe-u u okviru serijala Musicology.</p><p>Nik Vest je talentovana basistkinja i virtuoz 21. veka, kojoj ne nedostaju ni muzička kreativnost, ni scenski pokret. Specifična je po „čiroki“ frizuri koja je, simbolično – baš u obliku bas ključa.</p><p>Uz biografiju koja uključuje rad sa produkcijom Kvinsi Džons, Prinsom, Džonom Mejerom, Mejsi Grej, Dejvom Stjuartom i mnogim drugim muzičarima, Nik Vest je mnogo više od samo još jednog lepog lica.</p><p>Njene kolege muzičari, kritičari i publika, smatraju je za jednog od najistaknutijih predstavnika nove fank scene i za naslednicu legendarnog Prinsa, čija je štićenica bila i sa kojim je svojevremeno žuta štampa dovodila u vezu.</p>', 7, 15, 42, 20, '2019-05-26 19:00:00', '2019-04-17 18:46:44', 'ticketVision', '2019-05-26 23:00:00', '06d31ea6-fe06-4a6f-9274-b6da0b519fae.jpg', 0),
(8, 'Orthodox Celts tradicionalno u Domu omladine', '<p>U nedelju, 17. marta od 20.00, u sali Amerikana Doma omladine Beograda tradicionalni koncert održaće grupa Orthodox Celts.</p><p>I ove godine popularni bend će sa svojom vernom publikom proslaviti Dan Svetog Patrika a to će biti 27. samostalni koncert u Beogradu.</p><p>Ovime se nastavlja najduža muzička tradicija koja je zabeležena u srpskom rokenrolu – Orthodox Celts su jedini bend koji, od svog nastanka, svake godine na isti dan održava koncert.</p><p>Poslednji album „<strong>Many Mouths Shut</strong>“ je pored odličnih pesama, obeležio i veoma interesantan omot u stripu, koji je specijalno za Orthodox Celts uradio poznati Valter Venturi, što je bendu predstavljalo posebnu čast. Zato je ove godine naš najveći izdavač stripova „Veseli četvrtak“ odlučio da svi posetioci uz ulaznicu dobiju i strip.</p>', 7, 15, 43, 20, '2019-05-17 22:00:00', '2019-04-17 18:48:19', 'ticketVision', '2019-05-18 02:00:00', 'c44c3609-1f0a-4b65-a67a-62e95fc7d0c7.jpg', 0),
(9, 'Beogradska ultimativna kulturna akcija – Buka! Sada!', '<p>U subotu, 18. maja, u KPGT prostorijama (Stara šećerana, Radnička 3) biće organizovana Beogradska&nbsp;ultimativna&nbsp;kulturna&nbsp;akcija – „Buka! Sada!“.</p><p><strong>„Buka!Sada!“</strong> je jedinstveno muzičko iskustvo jer okuplja neka od najzvučnijih frontmenskih imena iz celog regiona koji će – u jednoj noći, nastupiti u ulozi disk džokeja.</p><p>Posle prošlogodišnjeg, rasprodatog Buka! izdanja, ovog aprila za gramofonima na tri bine smenjivaće se: <strong>Mile Kekin</strong> (Hladno pivo),<strong> Ivan Novak</strong> (Laibach), <strong>Cane</strong> (Partibrejkers, Škrtice), <strong>Jovan Matić</strong> (Del Arno Band), <strong>Žika Todorović</strong> i <strong>Uroš Đurić</strong>, <strong>Dr Pop</strong> (Atheist Rap), <strong>Vukašin Marković</strong> (irieFM), <strong>Maja Cvetković</strong> (E-Play), <strong>Kojot</strong> (Hornsman Coyote, ex Eyesburn), <strong>Vasil Hadžimanov, Igor Perović</strong> (Plejboj), <strong>Bojan Slačala</strong> (Artan Lili, Stuttgart Online),<strong> Constructa &amp; Zoe Kida</strong> (Zemlja gruva), <strong>Boško Mijušković</strong> (Straight Mickey And The Boys, Škrtice)…</p><p>O muzici koju će puštati 13. aprila, <strong>Dr Pop iz benda Atheist Rap</strong> rekao je:</p><p>– Veoma mi je važno da budem deo žurke „Buka!Sada!“, deo sjajne ekipe kolega i koleginica.&nbsp;Puštaću svoje i, nadam se, favorite publike. Možete očekivati Me First and Gimmie Gimmies, Rich Kids on LSD, Bad Brains, Ruts, Gang of Four, NoFX, Kawasaki3P, TBF, Vojko V, Dubioza, Stereo Banana, Novembar i još dosta toga. Radujem se Buci!, već sada!</p><p>A <strong>Maja Cvetković iz benda E-Play</strong> dodaje:</p><p>– Interesantno mi je što sam pozvana da puštam muziku, s obzirom da to ne radim često. Fokusiraću se na ritmove koji su za mene bili revolucionarni – Prodigy, Propellerheads, Chemical Brothers… zatim neke novijie stvari poput Viagra Boys. Bez sporih pesama! Društvo u kome ću se naći vrlo je zanimljivo – verujem da će biti dobre muzike, atmosfere i puno osmeha.</p><p>Posle prošlogodišnje lokacije Kluz u centru Beograda, ovoga puta je zbog velikog interesovanja publike i neočekivano brze prodaje karata, „Buka! Sada!“ smeštena u veći, izuzetno atraktivan prostor pozorišta KPGT, sa bogatom klupskom istorijom.</p><p>Takođe, datum održavanja manifestacije „Buka! Sada!“&nbsp;nije slučajan – on obeležava i Record Store Day (13. april), globalnu manifestaciju koja slavi rokenrol, ploče, ljubav prema slušanju muzike i njenoj selekciji.</p><p>Karte su u prodaji na svim prodajnim mestima&nbsp;tikets.rs:</p><ul><li>promotivni kontigent 300 ulaznica po ceni od <strong>1.100 RSD</strong>;</li><li>regularna cena ulaznice je<strong> 1.300 RSD</strong>;</li><li>cena ulaznice na vratima je <strong>1.500 RSD</strong>.</li></ul>', 7, 15, 44, 19, '2019-05-18 19:00:00', '2019-04-24 22:59:30', 'kisobran', '2019-05-18 23:00:00', 'e295fc2c-53a1-4f48-9866-31401a2294bb.jpg', 0);

-- --------------------------------------------------------

--
-- Table structure for table `karakteristike_prostora`
--

CREATE TABLE `karakteristike_prostora` (
  `id_karakteristika` int(11) NOT NULL,
  `id_dogadjaj` int(11) NOT NULL,
  `id_stavka` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `karakteristike_prostora`
--

INSERT INTO `karakteristike_prostora` (`id_karakteristika`, `id_dogadjaj`, `id_stavka`) VALUES
(1, 1, 25),
(2, 1, 22),
(3, 2, 24),
(4, 2, 23),
(5, 2, 22),
(6, 2, 25),
(7, 3, 23),
(8, 3, 25),
(9, 4, 22),
(10, 5, 22),
(11, 6, 22),
(12, 7, 23),
(13, 9, 23),
(14, 9, 25),
(15, 9, 22),
(16, 9, 24);

-- --------------------------------------------------------

--
-- Table structure for table `korisnici`
--

CREATE TABLE `korisnici` (
  `korisnicko_ime` varchar(50) NOT NULL,
  `lozinka` binary(64) DEFAULT NULL,
  `salt` binary(16) DEFAULT NULL,
  `tip` tinyint(1) NOT NULL,
  `odobren` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `korisnici`
--

INSERT INTO `korisnici` (`korisnicko_ime`, `lozinka`, `salt`, `tip`, `odobren`) VALUES
('admin', 0xe53197da3a954069670e74083f305c3f541e71ce662c959c8abf014ab628f6a8d5cce06cb57963b9e276353548d3d7c9f87cafae04349b1fd80f384768c56006, 0xb77185db910f62b15a3d6bcf252e2ff4, 1, 1),
('arsCreativa', 0x68d9c4a32b63d14eae33bc971cdca748f9f2d98f6b8376e34a96c1b5b8aa3928b562cc5fed57822a20c35d17e412a1df51492da686273b621a2e569659c31876, 0x54b63c7ab18989590bcf15d678167253, 2, 1),
('kisobran', 0xd3e7abbff0f11a999c174ccc5a5d953a9179659f57121a4a42c0dd715166954dfaaf5331a832cc87dea12a7fcf767e2bb9a8db86a3c7a70f57f1c35c5402b24b, 0xb6b6fe5aaa8c70d4048342ed740be2fc, 2, 1),
('ORCA', 0x3f1de813bbf0a21b027dbc3ad70aff29eda79b460ed7ebb76643eeeda50d9852e4892f7ead55e4101e601cf5eea6f407a89aa264de83d457140d5cbbdeac89d2, 0x7274449dd454ae9b1d3472b202aa42cd, 2, 0),
('ticketVision', 0x3922fddfbdfa8039dfb9648382f66fa3edd155a88a5e71684beb02afa57db6b387510758deba33dda9309c27ce05446d92ad3468ce13091138a5f4a63db4aae6, 0xc0e9bcbb4cd6d84c2f759b4d4f23928e, 2, 1),
('TobOrg', 0xed5c89542a901ba571556cafa6a2e5b1bb046a3d96c59cf485abc4f67689622bc9497fea40b8e790cda356d23f1c7323161b14285cf34dbce89a895a90278355, 0x53452c9e28164d3a43e237c50ae57e6f, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `obavestenja`
--

CREATE TABLE `obavestenja` (
  `id_obavestenje` int(11) NOT NULL,
  `korisnicko_ime` varchar(50) NOT NULL,
  `datum` datetime NOT NULL,
  `tekst` text NOT NULL,
  `id_vest` int(11) DEFAULT NULL,
  `id_dogadjaj` int(11) DEFAULT NULL,
  `id_oglas` int(11) DEFAULT NULL,
  `procitano` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `obavestenja`
--

INSERT INTO `obavestenja` (`id_obavestenje`, `korisnicko_ime`, `datum`, `tekst`, `id_vest`, `id_dogadjaj`, `id_oglas`, `procitano`) VALUES
(1, 'kisobran', '2019-04-24 22:56:21', 'Korisnik je arhivirao vest:', 7, NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `odgovori`
--

CREATE TABLE `odgovori` (
  `id_odgovor` int(11) NOT NULL,
  `id_popunjena_anketa` int(11) NOT NULL,
  `id_ponudjeni_odgovor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `odgovori`
--

INSERT INTO `odgovori` (`id_odgovor`, `id_popunjena_anketa`, `id_ponudjeni_odgovor`) VALUES
(1, 1, 32),
(2, 1, 29),
(3, 1, 30),
(4, 1, 37),
(5, 1, 34),
(6, 1, 40),
(7, 2, 21),
(8, 2, 3),
(9, 2, 13),
(10, 2, 10),
(11, 2, 7),
(12, 2, 26),
(13, 2, 17),
(14, 3, 42),
(15, 3, 50),
(16, 3, 47),
(17, 3, 48),
(18, 4, 28),
(19, 4, 40),
(20, 4, 37),
(21, 5, 1),
(22, 5, 26),
(23, 5, 10),
(24, 5, 21),
(25, 5, 18),
(26, 5, 11),
(27, 6, 42),
(28, 6, 53),
(29, 6, 50),
(30, 6, 52),
(31, 6, 56),
(32, 7, 52),
(33, 7, 50),
(34, 7, 56),
(35, 7, 53),
(36, 7, 48),
(37, 7, 47),
(38, 7, 42),
(39, 8, 37),
(40, 8, 40),
(41, 8, 32),
(42, 9, 21),
(43, 9, 3),
(44, 9, 10),
(45, 9, 16),
(46, 9, 12),
(47, 9, 26),
(48, 10, 62),
(49, 10, 72),
(50, 10, 77),
(51, 10, 67),
(52, 10, 57);

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
  `korisnicko_ime` varchar(50) NOT NULL,
  `zahtev_brisanje` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `oglasi`
--

INSERT INTO `oglasi` (`id_oglas`, `naslov`, `tekst`, `datum_kreiranja`, `datum_isticanja`, `korisnicko_ime`, `zahtev_brisanje`) VALUES
(1, 'Content writer', '<p>Requirements:</p><ul><li>Near-native English proficiency</li><li>Work experience is desirable</li><li>Basic understanding of keyword usage and SEO is a plus</li><li>Ability to conduct in-depth research on a variety of topics using the internet</li><li>Working knowledge of Google Docs, Microsoft Word or similar software</li><li>Ability to thrive in a fast-paced, deadline-oriented environment</li></ul><p>Your Responsibilities:</p><p>● Thoroughly researching the topic of the task</p><p>● Writing unique Search Engine Optimized articles</p><p>● Editing your previously written articles according to the recommendations from our proofreaders</p><p>What we offer:</p><p>● Working in a relaxed environment</p><p>● Great prospects for career advancement and valuable work experience for</p><p>people just starting their career.</p><p>● Full-time position</p><p>Please send your CV and cover letter to: career@kisobran.org</p>', '2019-04-17 19:08:13', '2019-06-01 23:59:59', 'kisobran', 0),
(2, 'Novinar/novinarka', '<p>Potrebna</p><p>Novinarka - novinar</p><p><strong> za snimanje priloga i pripremu TV emisije koja se emituje na Pink 3, KCN-u i jos 40 TV stanica u regionu. </strong></p><p>(youtube <strong> stazetv </strong>)</p><p><strong> Poslati: </strong></p><ul><li>CV</li><li>fotografiju tela i lica</li><li>neki snimak koji ste već objavili</li></ul>', '2019-04-17 19:09:04', '2019-05-17 23:59:59', 'kisobran', 0),
(3, 'Prodavac', '<h3>Radni zadaci su u sledećim okvirima:</h3><ul><li>Izgrađivanje i održavanje dobrih poslovnih odnosa sa kupcima</li><li>Održavanje urednosti radnog prostora</li><li>Praćenje asortimana proizvoda</li></ul><h3>Kandidati treba da ispunjavaju sledeće zahteve:</h3><ul><li>Računarska pismenost (MS Office, MS Excel)</li><li>Znanje engleskog jezika</li></ul><h3>Profil kandidata:</h3><ul><li>Odlične komunikacione sposobnosti</li><li>Izražene prodajne veštine i veštine prezentacije</li><li>Razvijen osećaj za estetiku</li><li>Ljubaznost, pedantnost i efikasnost u radu</li></ul>', '2019-04-17 19:13:50', '2019-05-25 23:59:59', 'ticketVision', 0),
(4, 'Menadžera tima (m/ž)', '<h3>Vaši zadaci obuhvataće:</h3><ul><li>Prijem, pripremanje i prezentaciju robe u skladu sa zadatim uputstvima</li><li>Pripremu robe za prodaju</li><li>Pripremne poslove za akcije</li><li>Odgovornost za promet</li><li>Plan radnog vremena zaposlenih, podsticanje i motivisanje zaposlenih</li><li>Brigu za kupce</li><li>Održavanje čistoće i reda u poslovnici</li><li>Organizaciju i vođenje poslovnice i opšte administrativne poslove</li><li>Sprovođenje internih smernica koncerna</li></ul><h3>Traženi profil:</h3><ul><li>Vrlo dobro znanje engleskog jezika u govoru i pisanju je obavezno</li><li>Višegodišnje radno iskustvo u maloprodaji</li><li>Iskustvo u vođenju ljudi i sposobnost kvalitetnog rešavanja konflikata</li><li>Završeno obrazovanje u struci - maloprodaja ili drugo obrazovanje uz odgovarajuće radno iskustvo</li><li>Zainteresovanost za modu i profesionalan nastup</li><li>Samostalnost u radu i sposobnost timskog rada</li><li>Vremenska fleksibilnost unutar uobičajenog radnog vremena u trgovini</li></ul><h3>Nudimo Vam:</h3><ul><li>Dinamično i brzo rastuće radno okruženje i dugoročnu perspektivu</li><li>Prijatnu radnu klimu i posvećeni tim</li><li>Radni odnos na puno radno vreme unutar uobičajenog radnog vremena u trgovini</li></ul><p>Ukoliko smo Vas zainteresovali za ovo radno mesto, pošaljite nam Vašu potpunu konkursnu dokumentaciju sa slikom na srpskom i engleskom jeziku&nbsp;elektronskim putem <strong>do 25.04.2019.</strong>&nbsp;U obzir ćemo uzeti samo konkursnu dokumentaciju dostavljenu na oba jezika.</p><p>Ovim putem svim kandidatima želimo da zahvalimo na interesovanju za posao u našoj kompaniji. Sve prijave će biti obrađene, a kandidate koji najbolje zadovoljavaju uslove konkursa kontaktiraćemo u vrlo kratkom roku. Ostalim kandidatima zahvaljujemo na iskazanom poverenju i želimo uspešan nastavak profesionalne karijere.</p>', '2019-04-24 23:26:30', '2019-03-25 23:59:59', 'kisobran', 0);

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
('arsCreativa', 'Ars Creativa', 'Amina Lagumdžija', 'office@arscreativa.org', 'ARS CREATIVA istražuje, pruža podršku i prezentuje nastupe, podstičući saradnju umetnosti, prirodnih i društvenih nauka. Sarađuje sa umetnicima i institucijama – organizatorima prostora za nastupe, predstavljaući radionice, edukativne programe kao i saradnju u okviru multidisciplinarnih projekata.\nARS CREATIVA je nevladina, nestranačka, samostalna i neprofitna organizacija, koja ima za cilj da proširi granice pristupačnosti vremenski ograničenog rada, te da stvori nove mogućnosti za saradnju medju umetnicima svih branši.', 32, 'http://arscreativa.org', 15, 33, '0113067038'),
('kisobran', 'Kišobran orhanizacija', 'Marko Filipović', 'info@kisobran.org', 'Kišobran je organizacija koja se bavi promocijom nezavisne kulture i umetnosti.\nTo zvuči baš rogobatno, zar ne? Zapravo mi smo grupa dobrih drugara koja od 2008. organizuje žurke indie i alternativne muzike, eksperimentiše sa vj-ingom i fotografijom, organizuje koncerte i promoviše art projekte koji nam se dopadaju.', 34, 'http://kisobran.org', 15, 35, '062262734'),
('ORCA', 'ORCA', 'Dragana Tar', 'info@orca.rs', 'ORCA je organizacija civilnog društva koja pomaže ljudima u Srbiji i na Zapadnom Balkanu da brinu o prirodi i dobrobiti životinja kako bi ostvarili lični, ekonomski i društveni razvoj. Svoju misiju ostvarujemo kroz javno zastupanje, istraživanje, obrazovanje i praćenje primene politika i propisa. Kroz javno zastupanje, utičemo na usvajanje boljih zakona, njihovo sprovođenje i promenu kulture društva u odnosu na prirodu i životinje.', 26, 'https://www.orca.rs', 15, 27, '0601844595'),
('ticketVision', 'Ticket Vision d.o.o.', 'Pavle Leverda', 'office@tickets.rs', 'Ticket Vision d.o.o. je registrovano preduzeće za elektronsko štampanje, distribuciju i prodaju ulaznica zasve vrste događaja putem interneta i mreže prodajnih mesta, prisutno na srpskom tržištu od 2005. godine.\nU ovom trenutku Ticket Vision d.o.o. ima mrežu sa više od 150 prodajnih mesta širom Srbije sa glavnim blagajnama u Beogradu – TC Ušće, blagajna u Domu omladine Beograda, blagajna Beogradske Arene i Bilet centar, prodaju putem webshopa na portalu tickets.rs, call center 0900 11 00 11 (cena poziva iz fiksne i mobilne mreže MTS-a iznosi 48,00 din/min. Porez je uračunat u cenu poziva).\nTicket Vision d.o.o. sistem za prodaju ulaznica je sveobuhvatan, sa jednostavnim i funkcionalnim prikazom prodaje i rezervacije ulaznica za muzičke, sportske, kulturne i druge događaje.', 28, 'https://www.tickets.rs', 15, 29, '0900110011'),
('TobOrg', 'Turistička organizacija Beograda', 'Miodrag Popović', 'tobsekretarica@tob.rs', 'Turistička organizacija Beograda je javna služba Skupštine grada Beograda, osnovana sa idejom da obavlja poslove razvoja, očuvanja i zaštite turističkih vrednosti na teritoriji Beograda.\nKao destinacijska menadžment organizacija, TOB u promociji Beograda, kao turističkog odredišta, objedinjuje turističke usluge hotela, restorana, turističkih agencija, proizvođača suvenira i starih zanata, organizatora manifestacija i svih drugih delatnosti koje pružaju usluge turistima koji posećuju Beograd.\nNaša misija je promocija Beograda kao atraktivnog turističkog odredišta, očuvanje i razvoj turističkih, kulturnih i poslovnih vrednosti i potencijala grada.', 30, 'http://www.tob.rs', 15, 31, '0113625060, 0113625064');

-- --------------------------------------------------------

--
-- Table structure for table `pitanja`
--

CREATE TABLE `pitanja` (
  `id_pitanje` int(11) NOT NULL,
  `id_anketa` int(11) NOT NULL,
  `pitanje` varchar(256) NOT NULL,
  `tip` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pitanja`
--

INSERT INTO `pitanja` (`id_pitanje`, `id_anketa`, `pitanje`, `tip`) VALUES
(1, 1, 'Da li vam se dopala prethodna kišobran žurka?', 1),
(2, 1, 'Šta možemo da učinimo da narednu kišobran žurku učinimo boljom?', 2),
(3, 1, 'Ocenite repertoar na kišobran žurkama:', 1),
(4, 1, 'Ocenite obezbeđenje na kišobran žurkama:', 1),
(5, 1, 'Ocenite izbor pića na kišobran žurkama:', 1),
(6, 1, 'Da li biste ponovo došli na kišobran žurku?', 1),
(7, 2, 'Kako ste saznali za kišobran organizaciju?', 2),
(8, 2, 'Kako ste saznali za prethodnu kišobran žurku?', 2),
(9, 2, 'Koji je vaš glavni izvor informacija o kišobran žurkama?', 1),
(10, 3, 'Izaberite poslastičarnicu sa najukusnijim italijanskim sladoledom:', 1),
(11, 3, 'Izaberite omiljene ukuse:', 2),
(12, 4, 'Ocenite pretragu vesti na portalu:', 1),
(13, 4, 'Ocenite pretragu događaja na portalu:', 1),
(14, 4, 'Ocenite pretragu oglasa na portalu:', 1),
(15, 4, 'Ocenite pretragu organizacija na portalu:', 1),
(16, 4, 'Ocenite pretragu anketa na portalu:', 1),
(17, 5, 'Da li administrator redovno odgovara na vaše zahteve za brisanje vesti/događaja/oglasa?', 1),
(18, 5, 'Da li je administrator nekada nepravedno obrisao vašu vest/događaj/oglas?', 1),
(19, 5, 'Da li ste dugo čekali na odobrenje naloga od strane administratora?', 1),
(20, 6, 'Da li ste zadovoljni korisničkim interfejsom portala?', 1),
(21, 6, 'Navedite šta vam od ponuđenih odgovora nedostaje na portalu:', 2),
(22, 7, 'Da li redovno čitate naše post-ove?', 1),
(23, 7, 'Da li smatrate da našem timu nedostaju profesionalniji novinari?', 1),
(24, 7, 'Ocenite kvalitet naših vesti u odnosu na vaše?', 1),
(25, 7, 'Da li biste zaposlili nekoga iz našeg tima?', 1),
(26, 7, 'Koliko ste bili iskreni u popunjavanju ove ankete?', 1);

-- --------------------------------------------------------

--
-- Table structure for table `ponudjeni_odgovori`
--

CREATE TABLE `ponudjeni_odgovori` (
  `id_odgovor` int(11) NOT NULL,
  `id_pitanje` int(11) NOT NULL,
  `odgovor` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ponudjeni_odgovori`
--

INSERT INTO `ponudjeni_odgovori` (`id_odgovor`, `id_pitanje`, `odgovor`) VALUES
(1, 1, 'Jedva čekam sledeću!'),
(2, 1, 'Da, dopala mi se.'),
(3, 1, 'Neutralan/a sam.'),
(4, 1, 'Ne, nije moj tip žurki.'),
(5, 1, 'Neću više nikad doći na kišobran žurku!'),
(6, 2, 'Veći izbor pića'),
(7, 2, 'Popularniji repertoar'),
(8, 2, 'Iskusniji izvođači'),
(9, 2, 'Veći prostor'),
(10, 2, 'Zabrana pušenja u prostorijama'),
(11, 3, '5'),
(12, 3, '4'),
(13, 3, '3'),
(14, 3, '2'),
(15, 3, '1'),
(16, 4, '5'),
(17, 4, '4'),
(18, 4, '3'),
(19, 4, '2'),
(20, 4, '1'),
(21, 5, '5'),
(22, 5, '4'),
(23, 5, '3'),
(24, 5, '2'),
(25, 5, '1'),
(26, 6, 'Da!'),
(27, 6, 'Ne...'),
(28, 7, 'Čuo/la sam od prijatelja.'),
(29, 7, 'Putem Fejsbuka.'),
(30, 7, 'Putem Instagrama.'),
(31, 7, 'Pomoću Google pretraživača.'),
(32, 7, 'Pomoću Kulturiške.'),
(33, 8, 'Čuo/la sam od prijatelja.'),
(34, 8, 'Putem Fejsbuka.'),
(35, 8, 'Putem Instagrama.'),
(36, 8, 'Pomoću Google pretraživača.'),
(37, 8, 'Pomoću Kulturiške.'),
(38, 9, 'Fejsbuk'),
(39, 9, 'Instagram'),
(40, 9, 'Kulturiška'),
(41, 9, 'Web stranica organizacije'),
(42, 10, 'Poslastičarnica Poslastičarnica'),
(43, 10, 'Crna Ovca'),
(44, 10, 'Moritz'),
(45, 10, 'Flor Gelato'),
(46, 10, 'Nisam probao/la.'),
(47, 11, 'vanila'),
(48, 11, 'čokolada'),
(49, 11, 'straćatela'),
(50, 11, 'pistaći'),
(51, 11, 'badem'),
(52, 11, 'lešnik'),
(53, 11, 'višnja'),
(54, 11, 'mango'),
(55, 11, 'pomorandža'),
(56, 11, 'kokos'),
(57, 12, '5'),
(58, 12, '4'),
(59, 12, '3'),
(60, 12, '2'),
(61, 12, '1'),
(62, 13, '5'),
(63, 13, '4'),
(64, 13, '3'),
(65, 13, '2'),
(66, 13, '1'),
(67, 14, '5'),
(68, 14, '4'),
(69, 14, '3'),
(70, 14, '2'),
(71, 14, '1'),
(72, 15, '5'),
(73, 15, '4'),
(74, 15, '3'),
(75, 15, '2'),
(76, 15, '1'),
(77, 16, '5'),
(78, 16, '4'),
(79, 16, '3'),
(80, 16, '2'),
(81, 16, '1'),
(82, 17, 'Da'),
(83, 17, 'Ne'),
(84, 17, 'Nisam do sada slao/la zahteve za brisanje'),
(85, 18, 'Da, više puta!'),
(86, 18, 'Da, jedanput ili dvaput.'),
(87, 18, 'Ne, nikada!'),
(88, 19, 'Da, više od nedelju dana.'),
(89, 19, 'Da, između 3 i 5 radnih dana.'),
(90, 19, 'Nalog mi je odobren nakon jednog radnog dana.'),
(91, 19, 'Ne, nalog mi je odobren nakon nekoliko minuta!'),
(92, 20, 'Da'),
(93, 20, 'Ne'),
(94, 21, 'Više kategorija za vesti'),
(95, 21, 'Više kategorija za događaje'),
(96, 21, 'Više karakteristika prostora za događaje'),
(97, 21, 'Više opcija za uzrsat kome je događaj namenjen'),
(98, 22, 'Da'),
(99, 22, 'Ponekad'),
(100, 22, 'Ne'),
(101, 23, 'Da'),
(102, 23, 'Ne'),
(103, 24, '5'),
(104, 24, '4'),
(105, 24, '3'),
(106, 24, '2'),
(107, 24, '1'),
(108, 25, 'Da'),
(109, 25, 'Ne'),
(110, 26, '5'),
(111, 26, '4'),
(112, 26, '3'),
(113, 26, '2'),
(114, 26, '1');

-- --------------------------------------------------------

--
-- Table structure for table `popunjene_ankete`
--

CREATE TABLE `popunjene_ankete` (
  `id_popunjena_anketa` int(11) NOT NULL,
  `id_anketa` int(11) NOT NULL,
  `korisnicko_ime` varchar(50) DEFAULT NULL,
  `cookie` varchar(36) DEFAULT NULL,
  `datum` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `popunjene_ankete`
--

INSERT INTO `popunjene_ankete` (`id_popunjena_anketa`, `id_anketa`, `korisnicko_ime`, `cookie`, `datum`) VALUES
(1, 2, 'TobOrg', NULL, '2019-04-25 01:48:18'),
(2, 1, 'TobOrg', NULL, '2019-04-25 01:49:12'),
(3, 3, NULL, '1bc7ce88-4ba6-44cd-a65e-471859153e36', '2019-04-25 01:49:42'),
(4, 2, NULL, '1bc7ce88-4ba6-44cd-a65e-471859153e36', '2019-04-25 01:50:26'),
(5, 1, NULL, '1bc7ce88-4ba6-44cd-a65e-471859153e36', '2019-04-25 01:51:25'),
(6, 3, 'kisobran', NULL, '2019-04-25 01:52:19'),
(7, 3, 'admin', NULL, '2019-04-25 01:53:00'),
(8, 2, 'admin', NULL, '2019-04-25 01:53:29'),
(9, 1, 'admin', NULL, '2019-04-25 01:53:58'),
(10, 4, NULL, '1bc7ce88-4ba6-44cd-a65e-471859153e36', '2019-04-25 02:19:21');

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
(1, 'Kategorije vesti'),
(2, 'Kategorije događaja'),
(3, 'Mesta'),
(4, 'Uzrast'),
(5, 'Ulice'),
(6, 'Oblasti delovanja'),
(7, 'Karakteristike prostora');

-- --------------------------------------------------------

--
-- Table structure for table `sifarnici_izvestaj`
--

CREATE TABLE `sifarnici_izvestaj` (
  `id_sifarnik` int(11) NOT NULL,
  `naziv` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sifarnici_izvestaj`
--

INSERT INTO `sifarnici_izvestaj` (`id_sifarnik`, `naziv`) VALUES
(1, 'Registrovani korisnici'),
(2, 'Odbijeni korisnici'),
(3, 'Obrisani korisnici'),
(4, 'Kreirane vesti'),
(5, 'Arhivirane vesti'),
(6, 'Obrisane vesti'),
(7, 'Kreirani događaji'),
(8, 'Obrisani događaji'),
(9, 'Kreirani oglasi'),
(10, 'Obrisani oglasi'),
(11, 'Dodate stavke'),
(12, 'Obrisane stavke'),
(13, 'Kreirane ankete'),
(14, 'Popunjene ankete'),
(15, 'Obrisane ankete');

-- --------------------------------------------------------

--
-- Table structure for table `stavke_izvestaj`
--

CREATE TABLE `stavke_izvestaj` (
  `id_stavka` int(11) NOT NULL,
  `naziv` varchar(256) NOT NULL,
  `datum` datetime NOT NULL,
  `id_sifarnik` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `stavke_izvestaj`
--

INSERT INTO `stavke_izvestaj` (`id_stavka`, `naziv`, `datum`, `id_sifarnik`) VALUES
(1, 'Kategorije vesti: Muzika', '2019-04-17 16:54:41', 11),
(2, 'Kategorije vesti: Film', '2019-04-17 16:57:22', 11),
(3, 'Kategorije vesti: Pozorište', '2019-04-17 16:57:39', 11),
(4, 'Kategorije vesti: Umetnost', '2019-04-17 16:58:30', 11),
(5, 'Kategorije vesti: Pozorište', '2019-04-17 16:59:18', 12),
(6, 'Kategorije vesti: Književnost', '2019-04-17 16:59:51', 11),
(7, 'Kategorije vesti: Turizam', '2019-04-17 17:04:05', 11),
(8, 'Kategorije događaja: Koncerti', '2019-04-17 17:18:02', 11),
(9, 'Kategorije događaja: Clubbing', '2019-04-17 17:18:06', 11),
(10, 'Kategorije događaja: Festivali', '2019-04-17 17:18:25', 11),
(11, 'Kategorije događaja: Sajmovi', '2019-04-17 17:18:28', 11),
(12, 'Kategorije događaja: Radionice', '2019-04-17 17:18:53', 11),
(13, 'Kategorije događaja: Izložbe', '2019-04-17 17:19:28', 11),
(14, 'Kategorije događaja: Pozorišta', '2019-04-17 17:20:48', 11),
(15, 'Kategorije događaja: Bioskop', '2019-04-17 17:21:01', 11),
(16, 'Mesta: Beograd', '2019-04-17 17:21:09', 11),
(17, 'Mesta: Novi Sad', '2019-04-17 17:21:19', 11),
(18, 'Mesta: Kragujevac', '2019-04-17 17:21:24', 11),
(19, 'Uzrast: Deca', '2019-04-17 17:21:54', 11),
(20, 'Uzrast: Odrasli', '2019-04-17 17:22:03', 11),
(21, 'Uzrast: Deca', '2019-04-17 17:22:09', 12),
(22, 'Uzrast: Odrasli', '2019-04-17 17:22:11', 12),
(23, 'Uzrast: Deca', '2019-04-17 17:23:09', 11),
(24, 'Uzrast: Tinejdžeri', '2019-04-17 17:23:16', 11),
(25, 'Uzrast: Odrasli', '2019-04-17 17:23:20', 11),
(26, 'Uzrast: Penzioneri', '2019-04-17 17:25:24', 11),
(27, 'Karakteristike prostora: WiFi', '2019-04-17 17:25:40', 11),
(28, 'Karakteristike prostora: Parking', '2019-04-17 17:26:02', 11),
(29, 'Karakteristike prostora: Pet friendly', '2019-04-17 17:26:30', 11),
(30, 'Karakteristike prostora: Prilagođeno invalidima', '2019-04-17 17:26:53', 11),
(31, 'Oblasti delovanja: Zaštita životinja', '2019-04-17 17:32:05', 11),
(32, 'Ulice: Stjepana Filipovića 29', '2019-04-17 17:32:05', 11),
(33, 'ORCA', '2019-04-17 17:32:05', 1),
(34, 'Oblasti delovanja: Prodaja ulaznica', '2019-04-17 17:41:52', 11),
(35, 'Ulice: Bulevar Arsenija Čarnojevića 58', '2019-04-17 17:41:52', 11),
(36, 'ticketVision', '2019-04-17 17:41:52', 1),
(37, 'Oblasti delovanja: Turistička organizacija', '2019-04-17 17:48:35', 11),
(38, 'Ulice: Francuska 24', '2019-04-17 17:48:35', 11),
(39, 'TobOrg', '2019-04-17 17:48:35', 1),
(40, 'Oblasti delovanja: Izvođačka umetnost', '2019-04-17 17:56:46', 11),
(41, 'Ulice: Bulevar Umetnosti 3', '2019-04-17 17:56:46', 11),
(42, 'arsCreativa', '2019-04-17 17:56:46', 1),
(43, 'Oblasti delovanja: Promocija nezavisne kulture i umetnosti', '2019-04-17 18:03:02', 11),
(44, 'Ulice: Cetinjska 15', '2019-04-17 18:03:02', 11),
(45, 'kisobran', '2019-04-17 18:03:02', 1),
(46, 'Blazin’ Quartet promoviše novi album', '2019-04-17 18:05:11', 4),
(47, 'Novi album: Daft Punk – Random Access Memories', '2019-04-17 18:07:02', 4),
(48, 'Novi album: Zaz – Recto Verso', '2019-04-17 18:08:23', 4),
(49, 'Novi album: Depeche Mode – Delta Machine', '2019-04-17 18:10:09', 4),
(50, 'NOVA STARA PRIČA: Stigao prvi zvanični trejler filma "Kralj lavova"', '2019-04-17 18:15:40', 4),
(51, 'NOVO POGLAVLJE U SAGI: Stiže nastavak "Ratova zvezda"', '2019-04-17 18:16:37', 4),
(52, 'Novi album: Kelly Clarkson – Stronger', '2019-04-17 18:18:02', 4),
(53, 'Novi album: Decontrolled – The Circle', '2019-04-17 18:20:41', 4),
(54, 'Narodni muzej: „Beogradska mumija“ u stalnoj postavci', '2019-04-17 18:24:39', 4),
(55, 'Dan žena 2019: Besplatan ulaz u muzeje', '2019-04-17 18:26:04', 4),
(56, 'Kalemegdan: Prvi Kineski festival svetla', '2019-04-17 18:27:41', 4),
(57, '16. Noć muzeja u Srbiji: Vudstok, Tuluz-Lotrek i Neispričane priče', '2019-04-17 18:30:47', 7),
(58, 'BINA 2019 – 14. Beogradska internacionalna nedelja arhitekture', '2019-04-17 18:33:48', 7),
(59, 'KC „Čukarica“: 78 dana…', '2019-04-17 18:36:42', 7),
(60, 'Kišobran žurka // 09. jun 2019. // Drugstore', '2019-04-17 18:39:45', 7),
(61, 'Kišobran žurka – 10 godina // 01. avgust 2019. // Drugstore', '2019-04-17 18:41:17', 7),
(62, 'Kišobran žurka // Subota 13. oktobar, 23h // Kc Grad', '2019-04-17 18:43:31', 7),
(63, 'Musicology: Nik Vest', '2019-04-17 18:46:44', 7),
(64, 'Orthodox Celts tradicionalno u Domu omladine', '2019-04-17 18:48:19', 7),
(65, 'Coffee Room: Vaš miran kutak u centru Beograda!', '2019-04-17 18:52:10', 4),
(66, 'Restoran Enso: Goût de France – Ukusi Francuske', '2019-04-17 18:52:54', 4),
(67, 'O.U.R. Pub: Češka pivnica u srcu Beograda', '2019-04-17 18:53:42', 4),
(68, 'Upoznaj Srbiju, svrati na Zlatibor!', '2019-04-17 18:54:23', 4),
(69, 'Vikend van Beograda: Zašto baš Niš?', '2019-04-17 18:55:05', 4),
(70, 'Udobno i atraktivno krstarenje Drinom', '2019-04-17 18:55:42', 4),
(71, 'Content writer', '2019-04-17 19:08:14', 9),
(72, 'Novinar/novinarka', '2019-04-17 19:09:04', 9),
(73, 'Prodavac', '2019-04-17 19:13:50', 9),
(74, 'Kategorije vesti: nova kategorija', '2019-04-17 23:03:53', 11),
(75, 'Kategorije vesti: nova kategorija', '2019-04-17 23:04:21', 12),
(76, 'Moja prva anketa', '2019-04-18 01:32:16', 13),
(77, 'Moja prva anketa', '2019-04-21 22:32:26', 14),
(78, 'Moja prva anketa', '2019-04-21 23:50:04', 14),
(79, 'Moja prva anketa', '2019-04-22 01:54:34', 14),
(80, 'Moja druga anketa', '2019-04-22 01:55:00', 14),
(81, 'test anketa', '2019-04-22 02:11:19', 13),
(82, 'Kisobran anketa', '2019-04-23 16:38:07', 13),
(83, 'Moja prva anketa', '2019-04-23 22:39:31', 14),
(84, 'Kisobran anketa', '2019-04-24 00:34:08', 14),
(85, 'test anketa', '2019-04-24 01:26:52', 14),
(86, 'Moja prva anketa', '2019-04-24 01:48:57', 15),
(87, 'Kisobran anketa', '2019-04-24 01:50:12', 15),
(88, 'test anketa', '2019-04-24 01:50:13', 15),
(89, 'Moja druga anketa', '2019-04-24 01:50:16', 15),
(90, 'test', '2019-04-24 02:04:28', 1),
(91, 'asdsadsa', '2019-04-24 02:04:59', 4),
(92, 'dadssa', '2019-04-24 02:05:36', 7),
(93, 'DSDA', '2019-04-24 02:05:58', 9),
(94, 'DASD', '2019-04-24 02:06:27', 13),
(95, 'anketa', '2019-04-24 02:07:10', 13),
(96, 'anketa', '2019-04-24 02:07:24', 14),
(97, 'test', '2019-04-24 02:07:59', 3),
(98, 'anketa', '2019-04-24 02:08:12', 15),
(99, 'Ninina anketa', '2019-04-24 17:17:28', 13),
(100, 'admin anketa', '2019-04-24 17:34:54', 13),
(101, 'Jos malo gotovooo', '2019-04-24 17:35:19', 13),
(102, 'Jos malo gotovooo', '2019-04-24 17:46:57', 15),
(103, 'admin anketa', '2019-04-24 17:51:09', 15),
(104, 'Ninina anketa', '2019-04-24 17:52:40', 15),
(105, 'sdad', '2019-04-24 17:56:45', 13),
(106, 'anketa', '2019-04-24 17:57:02', 13),
(107, 'anketa', '2019-04-24 17:57:14', 15),
(108, 'sdad', '2019-04-24 17:57:15', 15),
(109, 'Kisobran anketa', '2019-04-24 17:57:30', 13),
(110, 'anketa', '2019-04-24 17:57:49', 13),
(111, 'Kisobran anketa', '2019-04-24 17:58:06', 13),
(112, 'admin anketa', '2019-04-24 17:58:27', 13),
(113, 'Jos malo gotovooo', '2019-04-24 17:58:48', 13),
(114, 'admin anketa', '2019-04-24 17:59:19', 13),
(115, 'admin anketa', '2019-04-24 17:59:24', 15),
(116, 'Kisobran anketa', '2019-04-24 17:59:31', 15),
(117, 'anketa', '2019-04-24 17:59:35', 15),
(118, 'admin anketa', '2019-04-24 17:59:36', 15),
(119, 'Jos malo gotovooo', '2019-04-24 17:59:37', 15),
(120, 'Kisobran anketa', '2019-04-24 17:59:37', 15),
(121, 'Adminova anketa', '2019-04-24 21:01:57', 13),
(122, 'Adminova anketa 2', '2019-04-24 21:02:30', 13),
(123, 'Adminova anketa 3', '2019-04-24 21:02:52', 13),
(124, 'Adminova anketa 4', '2019-04-24 21:03:30', 13),
(125, 'Adminova anketa 5', '2019-04-24 21:03:56', 13),
(126, 'anketica', '2019-04-24 21:06:58', 13),
(127, 'Kisobran anketa', '2019-04-24 21:11:24', 13),
(128, 'Kisobran anketa za korisnike', '2019-04-24 21:12:13', 13),
(129, 'Anketa za korisnike', '2019-04-24 21:13:34', 13),
(130, 'Anketa za korisnike', '2019-04-24 21:14:04', 14),
(131, 'Kisobran anketa za korisnike', '2019-04-24 21:14:15', 14),
(132, 'Kisobran anketa', '2019-04-24 21:14:21', 14),
(133, 'Kisobran anketa', '2019-04-24 21:14:35', 15),
(134, 'Kisobran anketa za korisnike', '2019-04-24 21:14:36', 15),
(135, 'Anketa za korisnike', '2019-04-24 21:14:38', 15),
(136, 'anketica', '2019-04-24 21:14:45', 15),
(137, 'Adminova anketa 3', '2019-04-24 21:14:47', 15),
(138, 'Adminova anketa 2', '2019-04-24 21:15:01', 15),
(139, 'Adminova anketa 4', '2019-04-24 21:15:02', 15),
(140, 'Adminova anketa 5', '2019-04-24 21:15:02', 15),
(141, 'Adminova anketa', '2019-04-24 21:15:03', 15),
(142, 'Nova vest od kisobrana', '2019-04-24 22:24:53', 4),
(143, 'Nova vest od kisobrana', '2019-04-24 22:25:36', 5),
(144, 'Nova vest od kisobrana', '2019-04-24 22:25:48', 6),
(145, 'Novi Dogadjaj', '2019-04-24 22:26:42', 7),
(146, 'Novi oglas', '2019-04-24 22:27:03', 9),
(147, 'Kisobran anketa', '2019-04-24 22:27:34', 13),
(148, 'Kisobran anketa', '2019-04-24 22:27:47', 13),
(149, 'Kisobran anketa', '2019-04-24 22:27:56', 13),
(150, 'Kisobran anketa', '2019-04-24 22:28:07', 13),
(151, 'Kisobran anketa', '2019-04-24 22:28:16', 13),
(152, 'Kisobran anketa', '2019-04-24 22:28:23', 13),
(153, 'Novi Dogadjaj', '2019-04-24 22:29:52', 8),
(154, 'Nova vest', '2019-04-24 22:31:33', 4),
(155, 'Nova vest', '2019-04-24 22:31:57', 5),
(156, 'Nova vest', '2019-04-24 22:32:00', 6),
(157, 'Novi oglas', '2019-04-24 22:32:58', 10),
(158, 'Novi Dogadjaj', '2019-04-24 22:33:42', 7),
(159, 'Novi Dogadjaj', '2019-04-24 22:34:43', 8),
(160, 'Nova vest', '2019-04-24 22:43:33', 4),
(161, 'Novi Dogadjaj', '2019-04-24 22:44:46', 7),
(162, 'Oglas 1', '2019-04-24 22:45:04', 9),
(163, 'Oglas 2', '2019-04-24 22:45:24', 9),
(164, 'Oglas 3', '2019-04-24 22:45:31', 9),
(165, 'Oglas 4', '2019-04-24 22:45:39', 9),
(166, 'Oglas 5', '2019-04-24 22:45:47', 9),
(167, 'Oglas 6', '2019-04-24 22:45:53', 9),
(168, 'Oglas 7', '2019-04-24 22:45:57', 9),
(169, 'Nova vest', '2019-04-24 22:46:54', 5),
(170, 'Nova vest', '2019-04-24 22:46:56', 6),
(171, 'Novi Dogadjaj', '2019-04-24 22:47:16', 8),
(172, 'Oglas 5', '2019-04-24 22:47:42', 10),
(173, 'Oglas 3', '2019-04-24 22:47:48', 10),
(174, 'Oglas 7', '2019-04-24 22:47:54', 10),
(175, 'Oglas 1', '2019-04-24 22:48:04', 10),
(176, 'Oglas 6', '2019-04-24 22:48:07', 10),
(177, 'Oglas 4', '2019-04-24 22:48:13', 10),
(178, 'Oglas 2', '2019-04-24 22:48:16', 10),
(179, 'Kisobran anketa', '2019-04-24 22:48:43', 15),
(180, 'Kisobran anketa', '2019-04-24 22:48:48', 15),
(181, 'Kisobran anketa', '2019-04-24 22:48:49', 15),
(182, 'Kisobran anketa', '2019-04-24 22:48:50', 15),
(183, 'Kisobran anketa', '2019-04-24 22:48:51', 15),
(184, 'Kisobran anketa', '2019-04-24 22:48:52', 15),
(185, 'Novi album: Kelly Clarkson – Stronger', '2019-04-24 22:56:21', 5),
(186, 'Beogradska ultimativna kulturna akcija – Buka! Sada!', '2019-04-24 22:59:30', 7),
(187, 'Test vest', '2019-04-24 23:03:41', 4),
(188, 'Test vest', '2019-04-24 23:03:44', 5),
(189, 'Test dogadjaj', '2019-04-24 23:04:26', 7),
(190, 'test oglas', '2019-04-24 23:04:49', 9),
(191, 'test oglas', '2019-04-24 23:07:08', 10),
(192, 'Test vest', '2019-04-24 23:10:25', 6),
(193, 'Test dogadjaj', '2019-04-24 23:10:34', 8),
(194, 'Kisobran anketa', '2019-04-24 23:19:19', 13),
(195, 'Menadžera tima (m/ž)', '2019-04-24 23:26:30', 9),
(196, 'Kisobran anketa', '2019-04-25 01:19:25', 15),
(197, 'Bolje kišobran žurke', '2019-04-25 01:31:50', 13),
(198, 'Popularnost kišobran žurki', '2019-04-25 01:40:12', 13),
(199, 'Najbolji Italijanski sladoled u Beogradu', '2019-04-25 01:47:18', 13),
(200, 'Popularnost kišobran žurki', '2019-04-25 01:48:18', 14),
(201, 'Bolje kišobran žurke', '2019-04-25 01:49:12', 14),
(202, 'Najbolji Italijanski sladoled u Beogradu', '2019-04-25 01:49:42', 14),
(203, 'Popularnost kišobran žurki', '2019-04-25 01:50:26', 14),
(204, 'Bolje kišobran žurke', '2019-04-25 01:51:25', 14),
(205, 'Najbolji Italijanski sladoled u Beogradu', '2019-04-25 01:52:19', 14),
(206, 'Najbolji Italijanski sladoled u Beogradu', '2019-04-25 01:53:00', 14),
(207, 'Popularnost kišobran žurki', '2019-04-25 01:53:29', 14),
(208, 'Bolje kišobran žurke', '2019-04-25 01:53:58', 14),
(209, 'Kvalitet pretrage', '2019-04-25 01:57:26', 13),
(210, 'Iskustvo sa administratorom', '2019-04-25 02:06:32', 13),
(211, 'Korisnički interfejs portala', '2019-04-25 02:10:59', 13),
(212, 'Ocena sadržaja kišobran organizacije', '2019-04-25 02:18:21', 13),
(213, 'Kvalitet pretrage', '2019-04-25 02:19:21', 14),
(214, 'Dan žena 2019: Besplatan ulaz u muzeje', '2019-04-27 04:02:11', 5),
(215, 'test', '2019-04-27 04:09:22', 1),
(216, 'asdf', '2019-04-27 04:14:01', 4),
(217, 'asdf', '2019-04-27 04:14:04', 5),
(218, 'asdf', '2019-04-27 04:14:34', 7),
(219, 'asdf', '2019-04-27 04:14:47', 9),
(220, 'asdf', '2019-04-27 04:15:18', 13),
(221, 'asdf', '2019-04-27 04:15:35', 14),
(222, 'test', '2019-04-27 04:16:13', 2);

-- --------------------------------------------------------

--
-- Table structure for table `stavke_sifarnika`
--

CREATE TABLE `stavke_sifarnika` (
  `id_stavka` int(11) NOT NULL,
  `id_sifarnik` int(11) NOT NULL,
  `naziv` varchar(50) NOT NULL,
  `ikonica` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `stavke_sifarnika`
--

INSERT INTO `stavke_sifarnika` (`id_stavka`, `id_sifarnik`, `naziv`, `ikonica`) VALUES
(1, 1, 'Muzika', '8c5c4b24-881c-44c3-b71d-c42206ebd21f.png'),
(2, 1, 'Film', '8bbc2346-44e0-4bdf-b273-3656a5e30947.png'),
(4, 1, 'Umetnost', '353e52e3-5a09-4bb2-86be-3ec24d10c780.png'),
(5, 1, 'Književnost', 'df7868e3-23ea-49dd-b4ef-1159599dbb98.png'),
(6, 1, 'Turizam', '1cdae9d3-8cf2-4bad-91ff-3d8734938559.png'),
(7, 2, 'Koncerti', NULL),
(8, 2, 'Clubbing', NULL),
(9, 2, 'Festivali', NULL),
(10, 2, 'Sajmovi', NULL),
(11, 2, 'Radionice', NULL),
(12, 2, 'Izložbe', NULL),
(13, 2, 'Pozorišta', NULL),
(14, 2, 'Bioskop', NULL),
(15, 3, 'Beograd', NULL),
(16, 3, 'Novi Sad', NULL),
(17, 3, 'Kragujevac', NULL),
(18, 4, 'Deca', NULL),
(19, 4, 'Tinejdžeri', NULL),
(20, 4, 'Odrasli', NULL),
(21, 4, 'Penzioneri', NULL),
(22, 7, 'WiFi', 'a2cd35f6-2a85-4522-9da8-03e6731dac28.png'),
(23, 7, 'Besplatan parking', '00d76d33-51a1-4cfe-b9cd-fbd310c1974b.png'),
(24, 7, 'Pet friendly', '266f7bf0-c09e-4ff5-83ec-09b6ac4700fe.png'),
(25, 7, 'Prilagođeno invalidima', '875498f6-323f-4911-b3bc-905b90db126d.jpg'),
(26, 6, 'Zaštita životinja', NULL),
(27, 5, 'Stjepana Filipovića 29', NULL),
(28, 6, 'Prodaja ulaznica', NULL),
(29, 5, 'Bulevar Arsenija Čarnojevića 58', NULL),
(30, 6, 'Turistička organizacija', NULL),
(31, 5, 'Francuska 24', NULL),
(32, 6, 'Izvođačka umetnost', NULL),
(33, 5, 'Bulevar Umetnosti 3', NULL),
(34, 6, 'Promocija nezavisne kulture i umetnosti', NULL),
(35, 5, 'Cetinjska 15', NULL),
(36, 5, 'Studentski trg', NULL),
(37, 5, 'Mitropolita Petra 12', NULL),
(38, 5, 'Kirovljeva 6', NULL),
(39, 3, 'Beoograd', NULL),
(40, 5, 'Bulevar Despota Stefana 115', NULL),
(41, 5, 'Braće Krsmanović 4', NULL),
(42, 5, 'Mitropolita Petra 8', NULL),
(43, 5, 'Dečanska 6', NULL),
(44, 5, 'Radnička 3', NULL);

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
  `arhivirana` tinyint(1) NOT NULL,
  `zahtev_brisanje` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vesti`
--

INSERT INTO `vesti` (`id_vest`, `korisnicko_ime`, `kategorija`, `naslov`, `tekst`, `datum`, `thumbnail`, `arhivirana`, `zahtev_brisanje`) VALUES
(1, 'kisobran', 1, 'Blazin’ Quartet promoviše novi album', '<p>Džez sastav „Blazin’ Quartet” je najavio promociju novog albuma pod nazivom „La mer, la pierre, la terre, l’oiseau” (<em>More, kamen, zemlja, ptica</em>) za 7. april od 21 čas u Mikser House-u.</p><p>Nakon nastupa u Parizu, Amsterdamu i Roterdamu Blazin’ Quartet će se naći na beogradskoj sceni. Možda je najbolji opis ovog sastava dao&nbsp;kolumnista magazina „Rolling Stone” koji je muziku Blazin’ Quartet-a opisao kao dosetljive postmoderne ludorije.</p><p>Blazin’ Quartet je stvorio autentičnu mešavinu balkanskog melosa, modernog džeza i elektronske muzike. Kvartet čine Sarajlija i Parižanin Srđan Ivanović (bubnjevi), Kristof Panzani iz Francuske (saksofon, klarinet), Grk Andreas Polizogopulos (truba) i Bugarin Mihail Ivanov (kontrabas), koji stvaraju na relaciji Pariz-Beograd-Amsterdam. Kao gost na ovom albumu pojavljuje se i poznati italijanski gitarista Federiko Kasagrande.</p><p>„Možda bi završetak nekog vica bio drugačiji, ali kad spojite Grka, Bugarina, Francuza i Bosanca dobijate džez kvartet, koji voli da eksperimentiše sa zvucima i da kreira svoj muzički svet. Još specifičnije, svet balkanskog džeza”, objašnjava&nbsp;Srđan Ivanović, frontmen sastava Blazin’ Quartet. On dodaje da je lepota muzičkog jezika u tome što lako komuniciraju sa publikom sa različitih prostora: „Krčeći put do prepoznatljivosti svirali smo na različitim festivalima po Evropi, ali smo shvatili da u Parizu isto razumeju balkanski folklor kao i u Beogradu, Zagrebu ili Sarajevu.”</p><p>Blazin’ Quartet je 2008. pobedio na najvećem džez takmičenju u Holandiji „Dutch Jazz Competition” a iste godine je dobio priznanje „Holland Casino Jazz&amp;Pop Award”. O njemu su izveštavali brojni svetski mediji među kojima je i prestižni američki magazin „Downbeat”.</p><p>„Beograd se poslednjih godina učvrstio kao prestonica džeza o čemu svedoče široka ponuda za ljubitelje ove vrste muzike, kao i veliki broj posetilaca na festivalima, koncertima i svirkama. Nekada smo i mi bili deo te koncertne publike, a kako smo u ovaj album utisnuli mnoge delove naših života, tako su se na njemu našli i snažan duh Balkana i zaleđe beogradskih muzičara”, ističe&nbsp;Srđan Ivanović, bubnjar Blazin’ Quartet-a.</p><p>Do sada je Blazin’ Quartet objavio dva studijska albuma „Finding a Way” i „Jalkan Bazz”, dok će se novi album „La mer, la pierre, la terre, l’oiseau” uskoro naći u prodaji.</p><p><strong>Blazin’ Quartet na turneji po Srbiji</strong></p><p>Blazin’ Quartet će početkom aprila krenuti na mini-turneju po Srbiji. Njihoc nastup u Kulturnom centru Pančeva zakazan je za 3. april. Dan kasnije kvartet će se naći pred novosadskom&nbsp;publikom u multimedijalnom prostoru „Firchie Think Tank Studio”, a 5. aprila nastupiće u subotičkom „Klein House-u”. Kragujevačka publika će imati priliku da ih čuje 6. aprila u SKC-u.</p>', '2019-04-17 18:05:11', '809e56f1-f880-4bd8-82c0-c1244b5a8dcf.jpg', 0, 0),
(2, 'kisobran', 1, 'Novi album: Daft Punk – Random Access Memories', '<p>U prodaji je novi album sastava <strong>Daft Punk</strong> „<u>Random Access Memories</u>“ (RAM) koji je u Srbiji objavio Sony/Menart.</p><p>Posle osmogodišnje pauze tajanstveni par skriven iza metalnih kaciga, Thomas Bangalter i Guy-Manuel de Homem-Christo, napokon su odlučili da objave nov materijal.</p><p>Album o kome u superlativu priča ne samo fantastična ekipa poznatih saradnika, muzičara i producenata, već i muzička kritika širom sveta, snimljen je u najboljem studiju i nije se štedelo ni na čemu. „Random Access Memories“ je sniman i produciran da zvuči kao da je izašao iz muzičkog studija krajem sedamdesetih i početka osamdesetih godina i baziran je na mešavini diska, soft roka i progresivnog popa, uz povremeno korišćenje čitavog orkestra i hora, da bi zvučao što bogatije.</p><p>Za razliku od prethodnih albuma, Daft Punk su veoma retko koristili semplove ovoga puta. Osnovna ideja je bila da RAM bude slušan u celini, kao kompletan album, a poenta je iskazana pesmom „Give Life Back To Music“.</p><p>„Tehnologija je učinila muziku dostupnom na filozofski vrlo interesantan način, ali kada je svima omogućeno da stvaraju magiju, kao da je magija nestala“, objašnjava Bangalter.</p><p>RAM ima 13 pesama, od kojih je prvi singl, „<strong>Get lucky</strong>“ (peva <em>Pharell Williams</em>) verovatno najveći hit ove godine, a sigurno apsolutni hit leta.</p><p>Kombinacija saradnika različitih generacija i senzibiliteta, već je dovoljna da zainteresuje ne samo fanove već i širu publiku. Pored pomenutog Pharella, gostuju i Paul Williams, Giorgio Moroder, Nile Rodgers, Todd Edwards, DJ Chilly Gonzales, Panda Bear i Julian Casablancas.</p>', '2019-04-17 18:07:02', '365b8f43-a1e0-4fa7-98e6-737582a83474.jpg', 0, 0),
(3, 'kisobran', 1, 'Novi album: Zaz – Recto Verso', '<p>U prodaji je novi album francuske pevačice <strong>Zaz „Recto Verso“</strong> (Sony Music France / Menart).</p><p>„Recto Verso“ donosi optimizam za koji je, ponovo, zaslužan zvonak glas Isabell Geffroy, koja peva, jednostavno srećna što postoji.</p><p>Uvodna pesma albuma, „On ira“, ujedno i prvi singl, uspešno spaja prethodni studijski album i poput nekog neorealističnog mosta polako nas uvodi u divnu, raznobojnu i neobuzdanu avanturu. U naelektrisanoj pesmi „Nous Debout“, Zaz drži ogledalo čovečanstva na staklenim nogama i glavom u oblacima. Peva kako je slobodna volja tu da bi se shvatila i razumela. U „T’attends Quoi“ (Šta čekaš?), Zaz se udružuje sa Volo i K. Soltani da bi nas izdigla iznad planina Avganistana, da bi čuli vapaje naroda Sirije i Iraka.</p><p>Njen, na trenutke, hrapav vokal poziva nas da život živimo u potpunosti, što je ujedno i poruka transcedentne „Deterre“. U pesmi „Si“ podseća da slabi mogu naći snagu u jedinstvu, a pesma „Toujours“ govori o njenom magičnom detinjstvu, o danima kada se kao vlat trave njihala na vetru, dok pesma „Gamine“ opisuje trenutak odrastanja, prvih osećanja i senzacija. Nasuprot njoj u dirljivoj „Si Je Perds“, Zaz se smešta u glavu obolelog od Alcehajmerove bolesti, opisujući poslednji pogled na lica, panoramu, sve one stvari koje treba uzeti u potpunosti, dok zauvek o njima ne izgubimo svako sećanje.</p><p>Zaz je poslednjih godina jedan od najpopularnijih francuskih izvođača. „Recto Verso“, njen drugi studijski album, prvi je na listi naprodavanijih albuma u Francuskoj, Japanu, Hrvatskoj i Švajcarskoj.</p>', '2019-04-17 18:08:23', 'f3d82136-6c7c-4409-b0c9-b8ea407295e5.jpg', 0, 0),
(4, 'kisobran', 1, 'Novi album: Depeche Mode – Delta Machine', '<p>U izdanju Columbia/Sony/Menart i u Srbiji se pojavio novi album grupe<strong> </strong><a href="https://www.danubeogradu.rs/2012/10/depeche-mode-na-uscu-19-maja-2013/" rel="nofollow"><strong>Depeche Mode</strong></a> pod nazivom „Delta Machine“.</p><p>Trinaesti album jednog od najpopularnijih svetskih bendova spaja smelost i kreativnost koje su osigurale uspeh slavnih prethodnika, albuma „Songs Of Faith And Devotion“ i „Violator“.</p><p>„Prvi put smo zajedno slušali demo snimke i dopao nam se pravac kojim smo krenuli. Puno puta ranije, napravili bismo pesmu koja bi nam se dopala, ali bi onda svako od nas imao svoju ideju u kom smeru bi ta pesma trebalo da ide, da bi bila još bolja. Probali bismo deset različitih načina, a jedan bi bio i rege. Nikada ne funkcioniše, ali mi uvek pokušamo. Ovoga puta nismo to morali da radimo“, uz osmeh priznaje Martin.</p><p>Za više od trideset godina karijere, pioniri elektro popa prodali su više od 100 miliona ploča, rasprodavali karte koncerte na najvećim svetskim stadionima, imali pedesetak singlova na top listama u Americi i Britaniji. Ali, ponekad je i originalnoj inspiraciji potrebno osveženje.</p><p>Ovoga puta, oblik koji su dobijale nove pesme, najviše je vukao ka bluzu:</p><p> „To je uticaj Delta bluza, pomalo usporenog, pomalo ljigavog, pomalo prljavog“, objašnjava Gahan, a Martin dodaje: „Ovo je naša verzija bluza. Sviramo bluz već duže vreme, na naš način. Ako se vratite ploči ‘Violator’, tamo ima pesama koje vuku na bluz, kao i na albumima ‘Songs Of Faith And Devotion’ i ‘Ultra’. Mislim da smo tek sada spremni da taj bluz iskreno prihvatimo i da ga učinimo očiglednijim u naslovu“.</p><p>„Definitivno ima uticaja bluza“, objašnjava Gahan i dodaje: „Ono što spaja sve pesme je poziv za pomoć. To je takođe element bluza. Kao kad kukaš nad svojim problemima, a na kraju te muzika spase“.</p><p>Imali su pomoć, ponovo su angažovali producenta Bena Hilijera. On je bio snaga koja stoji iza dva prethodna albuma, „Playing The Angel“ i „Sounds Of The Universe“.</p><p>„On zna koliko smo uznapredovali i svestan je da ne možemo da se ponavljamo. Zato smo izabrali Bena, da nas usmeri napred, jer smo želeli da ovaj album bude manje opisan, više direktan“, kaže Gor.</p><p>„Delta Machine“ je postigao svoj cilj, usmerio je jedan od najuticajnijih bendova na nov put. Iako su sebi dali ime koje ukazuje na prolaznost i površnost, Depeche Mode, sa karijerom dužom od trideset godina i kreativnošću koja je i dalje na vrhuncu, dokazuju da su sve, samo ne prolazni trend.</p><p>Sva tri formata „Delta Machine“ (regularan CD, Deluxe CD i LP) albuma su u prodaji u našim muzičkim radnjama.</p>', '2019-04-17 18:10:09', 'c747256d-6a00-40ce-817d-b0f9682be027.jpg', 0, 0),
(5, 'kisobran', 2, 'NOVA STARA PRIČA: Stigao prvi zvanični trejler filma "Kralj lavova"', '<p>Kompanija Dizni objavila je prvi zvanični trejler filma "Kralj lavova", dugo iščekivanog rimejka crtaća iz 1994. godine.</p><p>Premijera filma zakazana je za 19. jul 2019. godine, nakon čega će "Kralj lavova", kako se očekuje, osvojiti ostatak sveta.</p><p>U filmu glasove životinjama pozajmljuju Bijonse (Nala), Donald Glover (Simba), Set Rodžen (Pumba), Bili Ajhner (Timon), Čuetel Edžiofor (Skar) i Džon Oliver (Zazu), a od stare postavke jedino je ostao Džejms Erl Džons koji pozajmljuje glas kralju Mufasi.</p><p>Scenario za film, koji je, kako možemo da naslutimo iz trejlera, vrlo sličan crtaću, napisao je Džef Nejtanson.</p>', '2019-04-17 18:15:40', '796f0c57-11c9-4d31-89ae-f8ecb6485d77.jpg', 0, 0),
(6, 'kisobran', 2, 'NOVO POGLAVLJE U SAGI: Stiže nastavak "Ratova zvezda"', '<p>Deveti nastavak filmske sage "Ratovi zvezda" dobiće ime "Uspon Skajvokera" i prikazaće povratak zlog imperatora Palpatina, saopštila je kompanija "Volt Dizni".</p><p>Kompanija je u Čikagu, na proslavi povodom "Ratova zvezda", prikazala prve inserte iz filma koji će se u decembru pojaviti u bioskopima, preneo je Rojters.</p><p>Na kraju trejlera se čuje imperatorov zlokoban smeh, a glumac koji je i u prethodnim filmovima igrao ulogu Palpatina, Ijan Makdiarmid, izašao je na scenu dok se prolamao buran aplauz.</p>', '2019-04-17 18:16:37', '2c7e13da-fb2d-4b0f-b8bf-1561824a0563.jpg', 0, 0),
(7, 'kisobran', 1, 'Novi album: Kelly Clarkson – Stronger', '<p><strong>Pobednica Američkog Idola 2002.godine, Kelly Clarkson poslednjih meseci apsolutno vlada svetskim muzičkim etrom, pa ta manija nije zaobišla ni nas. Nema komercijalne radio stanice u Srbiji koja ne zavrti singl „Stronger (What Doesn’t Kill You)“ bar tri puta dnevno! Na Bilboardovoj listi top 100 najboljih pop pesama, ova pesma se nalazi tri meseca, a već nedeljama je ‘zacementirana’ na mestu prvom mestu.</strong></p><p>Album „Stronger“ (Sony/Menart) se nalazi u prodaji i u našim muzičkim radnjama od kraja 2011. Muzička kritika ocenila ga je kao najbolji rad ove pevačice i kantautorke. Zbog prvog singla sa tog albuma, pesme „Mr. Know It All“, magazin Entertainment Weekly je nazvao Kelly „Samurajem u rušenju muškaraca“.</p><p>I zaista, Kelly Clarkson je stekla milione odanih obožavalaca impulsivnim, direktnim stihovima. Njene hit pesme „Miss Independent“, „Since U Been Gone“, „Walk Away“, „Never Again“, „Mr. Know It All“ i sada „Stronger (What Doesn’t Kill You)“ su glasne, ohrabrujuće himne koje Kelly ume da iznese do kraja svojim moćnim i jakim glasom kao i stabilnom pojavom i držanjem.</p><p>Za rezonantan i muzički raznovrstan album „Stronger“, Klarksonova kaže da je inspirisan muzikom Tine Turner, Princea, Sheryl Crow i Radiohead!</p>', '2019-04-17 18:18:02', NULL, 1, 0),
(8, 'kisobran', 1, 'Novi album: Decontrolled – The Circle', '<p><strong>Beogradski modern metal sastav Decontrolled, objaviće album „The Circle“ 16. aprila za online etiketu SMP Music. Album će moći besplatno da se preuzme na stranici </strong><a href="http://www.serbian-metal.org/" rel="nofollow"><strong>Srpskog metal portala</strong></a><strong>.</strong></p><p>Na albumu se nalazi 11 pesama, koje su snimljene u studiju „Chainroom“ u Senti, pod producentskom palicom Marjana Mijića. Muziku i aranžmane potpisuje Mr. Metal (osnivač benda), a tekstove Decontrolled.</p><p>Bend je nastao leta 2003, godine, kao one-man projekat (Mr. Metal Tica). Na nagovor prijatelja da nastavi sa pravljenjem muzike, Marko okuplja ceo bend. Muzika koju Decontrolled svira je varijacija od klasičnog metala, preko modernih metal rešenja, poput Sikth, Meshuggah, In Flames ili Soilwork, do punkrock stila tipa Blink 182, triphop metala (Senser) i elektronike.</p><p>Decontrolled danas čine pevač Mr. Metal, gitaristi Wook i Alexa Jonić, basista Alexa Milošević i bubnjar Tommy 69.</p>', '2019-04-17 18:20:41', '681ada88-9969-4c5c-be95-7c473320b31b.jpg', 0, 0),
(9, 'arsCreativa', 4, 'Narodni muzej: „Beogradska mumija“ u stalnoj postavci', '<p>Narodni muzej u Beogradu uvrstio je „Beogradsku mumiju“ u svoju stalnu postavku u okviru staroegipatske zbirke.</p><p> </p><p><strong>Od 6. aprila, pa svake naredne subote od 12.00</strong>, staroegipatska mumija biće dostupna posetiocima a o njoj će pričati stručni vodič Ivana Minić.</p><p>Mumiju „<strong>Nesmin</strong>“ kupio je 1888. godine Pavle Riđički i iste godine je poklonio Narodonom muzeju u Beogradu.</p><p>Drveni kovčeg u kojem se nalazi mumija antropoidnog je oblika. Poklopac i dno kovčega oblikovani su od po jednog velikog komada tamariksovog drveta. Na sredini donjeg dela poklopca, vertikalno teče dvostubačni hijeroglifski natpis, poznat kao 191. poglavlje egipatske Knjige mrtvih. Ovaj natpis je veoma redak i poznato je tek dvadesetak primera u svetu.</p><p>Nabavku specijalne vitrine za čuvanje i izlaganje mumije finansirao je Sekretarijat za privredu, a u cilju razvoja turizma i obogaćivanje turističke ponude grada Beograda.</p><p>Pored „Beogradske mumije“ u stalnoj postavci se mogu videti staregipatski kovčeg Nefer renepet, Ušabti figure, Skarabeji, Privesci božanstava, Ogrlica od fajansa i Džed stubovi.</p><p>Uz kupljenu kartu za stalnu postavku muzeja, posetioci neće dodatno plaćati stručno vođenje kroz ovu zbirku, niti je potrebna ranija prijava. <em>(Beoinfo)</em></p>', '2019-04-17 18:24:38', '646d7477-c263-41bf-a9ad-a83bdeb55639.jpg', 0, 0),
(10, 'arsCreativa', 4, 'Dan žena 2019: Besplatan ulaz u muzeje', '<p>Povodom međunarodnog Dana žena, u petak 8. marta, biće obezbeđen besplatan ulaz u pojedine beogradske muzeje.</p><p><br></p><h3>Narodni muzej i Muzej Vuka i Dositeja</h3><p>Uz razgovor, kafu i druženje sa članicama kolektiva Narodnog muzeja, pored mogućnosti za neposrednije upoznavanje i razgovor, biće organizovano i dodatno stručno vođenje od 14.00 za zainteresovane sugrađanke i gošće Beograda. Čuće se i priče koje se odnose na društveni položaj i prava žene. Podsećajući se zanimljivih prošlosti u autentičnom izložbenom prostoru sa jedinstvenim eksponatima, biće poređenja sa savremenim temama.</p><p><br></p><h3>Istorijski muzej Srbije</h3><p>Besplatan je ulaz za dame i njihove voljene u Istorijskom muzeju Srbije na Trgu Nikole Pašića, gde je u toku izložba „Kraj Velikog rata 1917-1918“.</p><p>Ova izložba upotpunjena je tematskim izložbama „Đorđe Čarapić Fusek, sekretar Kancelarije kraljevskih ordena – Život i delo“ i „Znamenja Prvog svetskog rata iz zbirke Istorijskog muzeja Srbije“, kao i gostujućom izložbom Centra za primenjenu istoriju „Spašavanje Srbije: američka misija i epidemija tifusa u Srbiji 1915“.</p><p><br></p><h3>Etnografski muzej</h3><p>U petak, 8. marta, ulaz će biti besplatan i u Etnografskom muzeju (Studentski trg 13).</p><p>Zainteresovani će moći da pogledaju stalnu izložbu „Narodna kultura Srba u 19. i prvoj polovini 20. veka“, kao i izložbe „Neuništivi muzej 1918-2018“, autorke Vesne Bižić-Omčikus i izložbu „Kalaši – poslednji pagani Hindukuša“, autora Konstantina Novakovića.</p>', '2019-04-17 18:26:04', 'f64ae3c5-fd5d-424a-adb9-8b2de730a6d9.jpg', 1, 0),
(11, 'arsCreativa', 4, 'Kalemegdan: Prvi Kineski festival svetla', '<p>Prvi Kineski festival svetla biće organizovan na Kalemegdanu povodom obeležavanja kineske Nove godine, a svečano otvaranje biće 4. februara.</p><p>Na platou kod „Ribara“ u kalemegdanskom parku, u ponedeljak, od 18.00 biće otvorena instalacija kineskih lampiona kojom će se prvi put zvanično proslaviti kineska Nova godina kod nas.</p><p>U organizaciji Balkanopolis centra za modernu tradiciju, uz podršku Vlade Srbije i kineske ambasade u Beogradu, izložbu otvaraju ambasadorka Kine Čen Bo, ministar kulture Vladan Vukosavljević i premijerka Ana Brnabić.</p><p>Do ove izložbe je došlo zahvaljujući kulturnoj razmeni između naše dve zemlje, na inicijativu i lično angažovanje pre svega našeg umetnika Slobodana Trkulje, kreativnog ambasadora Srbije, koji sa grupom Balkanopolis uživa izuzetnu popularnost u ovoj najmnogoljudnijoj zemlji na svetu.</p><p>Svetlosni spektakl kreirala je jedna od vodećih svetskih kompanija za izradu umetničkih lampiona – Zigong Haitjen iz Kine. Njihove svetlosne instalacije pod nazivom „Panda“, „Godišnja doba“, „Čudesni jelen“, „Šapat pingvina“ i još mnoge druge uvešće zainteresovanu publiku u čudesni svet mašte i svetla, koji će posebno biti zanimljiv najmlađima.</p><p>Ulaz za sve posetioce je besplatan!</p><p>Izložba će trajati od 4. do 24. februara, a lampioni će se upaliti svako veče od 17.00.</p>', '2019-04-17 18:27:41', '79a4f8b6-9381-4bc6-91eb-5a1e9ec73522.jpg', 0, 0),
(12, 'TobOrg', 6, 'Coffee Room: Vaš miran kutak u centru Beograda!', '<p>Da: postoji! Radi već nekoliko godina i čeka na vas! To je <strong>Coffee Room</strong>, kod hotela „Palas“, na adresi Topličin venac 17.</p><p>Miran kutak u centru Beograda koji, ako već nije, ima potencijal da postane vaša nova omiljena destinacija za kafu, kolač ili sladoled, kao i dobra lokacija da ugostite svoje prijatelje ili poslovne partnere koji su u poseti Beogradu.</p><p>Coffee Room nudi atmosferu ljupkih pariskih lokala uz odličnu slatku selekciju iz <strong>Home Made Company</strong> ponude: kolači i torte, macarons po originalnim francuskim recepturama, fenomenalan sladoled, brojni slatki poklon proizvodi „za poneti“.</p><p>Ponudu upotpunjuju lagani slani obroci (topla preporuka: Croque Madame, Kiš losos), a kako svaki ozbiljan lokal koji u svom nazivu ima „coffee“ mora imati i kafu vrhunskog kvaliteta, tako i Coffee Room nudi veliki izbor odličnih kafa i napitaka od kafe.</p><p>Izuzetno prijatan i šarmantan ambijent, gde se vodilo računa o zaista svakom detalju, od uniformi osoblja, preko lagane muzike, do specifičnog enterijera.</p><p>Na sjajan način uspelo se u nameri da se zadrži autentičan duh ovog dela Beograda, koji je prepoznatljiv po svom šarmu i arhitekturi i delima vrhunskih arhitekata, a da se ujedno stvori i doživljaj da ste negde u Parizu.</p><p>Slatki deo ponude je nešto po čemu je ovo mesto prepoznatljivo. Vrhunski kvalitet i ukus i izgled koji je uvek isti dobro je poznat beogradskim sladokuscima.</p><p>Za toplije dane preporučujemo Limeta Cheese Cake (limeta i mascarpone, izuzetno osvežava!) i Medenu jagodu (sveže jagode, čokoladne korice, vanil krem, malo meda…), a deo ponude čine presne torte pogodne za osobe sa dijabetesom, vegeterijance i vegane, gde morate probati novitet – Presna torta Jagoda&amp;Nana.</p><p>Posetioci mogu uživati i u najboljim macaronsima u regionu koji se proizvode po originalnim francuskim recepturama, od bademovog brašna, čokolada i voćnih filova koji stižu upravo iz Francuske. Pored macaronsa, možete kupiti brojne slatke poklon proizvode „za poneti“, ukusne i lepo dekorisane, u luksuznom pakovanju.</p><h3><strong>Coffee Room: Sladoledi!</strong></h3><p>Još nešto što u Coffee Room-u morate probati jesu Home Made sladoledi!</p><p>U svakom trenutku u ponudi je dvadesetak ukusa, a preporučujemo Mohito (kao pravi koktel, sa sve rumom, sadrži alkohol i ne služi se maloletnima!), sočni Mango i Tamna čokolada koja sadrži čak 50% prave čokolade, što je istinski raritet u proizvodnji sladoleda!</p><p>Deo ukusa sladoleda je bez glutena, neki su dijetalni, a neki posni.</p><h3><strong>Vaši momenti</strong></h3><p>Pozicija u neposrednoj blizini mirnog parka, dovoljno blizu strogog centra grada, a opet izmeštena od buke i vreve, Coffee Room pozicionira kao sjajnu lokaciju za sve koji žele malo „svojih momenata“, samo za sebe i sebi drage osobe.</p><p>Tokom leta lokal je pun stranaca, a atmosfera je prava kosmopolitska…</p><p>Coffee Room je već postao prepoznatljiva destinacija za sve ljubitelje kafea i restorana, kao mesto koje nudi odlične proizvode iprofesionalnu uslugu, uz autentičan i prelep enterijer.</p>', '2019-04-17 18:52:10', '976b2002-a5fc-4bb0-a690-34d9befae73a.jpg', 0, 0),
(13, 'TobOrg', 6, 'Restoran Enso: Goût de France – Ukusi Francuske', '<p>Od 20. do 25. marta u restoranu Enso, drugu godinu zaredom, biće održana manifestacija „Goût de France“ – Ukusi Francuske.</p><p>Manifestacija „Goût de France“ je ove godine veća nego ikada – na pet kontinenata, u 3000 restorana. Znači, 3000 šefova kuhinja širom sveta učestvuju na ovoj globalnoj gastronomskoj manifestaciji.</p><p>Godine 2015. počelo se sa 1000 restorana, drugo izdanje je okupilo 1700 restorana, dok je 2017. postignut cilj od čak 2000 restorana, šefova i menija u ponudi.</p><p>Ove godine je koncept malo promenjen, pa će u danima između 20. i 25. marta, gosti restorana Enso moći da izaberu tasting menu na francuski način, koji se sastoji od četiri ganga inspirisana francuskom kuhinjom.</p><h3>Goût de France u Beogradu: losos, petao, sirevi, kolači…</h3><p>Gastronomska fešta Goût de France – Ukusi Francuske ne nudi isti meni u celom svetu. Naprotiv, svaki majstor kulinarstva ima priliku da sastavi svoj meni, koristeći lokalne proizvode i tradiciju kao inspiraciju.</p><p>Glavni kuvari Enso restorana, Uroš Ivošević i Nedeljko Jerković su smelo odgovorili na ovaj zadatak.</p><p>Meni je inspirisan francuskom kuhinjom i osmišljen je „à la française“ držeći se tradicionalnog francuskog okvira: losos na tri načina, petao u vinu, čokoladni tart sa sladoledom od tartufa i francuski sirevi…</p><h3>***</h3><p>Goût de France (Ukusi Francuske) se organizuje na inicijativu jednog od najpoznatijih francuskih kuvara, Alena Dikasa (Alain Ducasse) i Ministarstva za spoljne poslove i međunarodni razvoj.</p><p>Koncepcija je nadahnuta davnašnjom idejom Ogista Eskofijea, koji je daleke 1912. godine organizovao Epikurovu večeru (istog dana, u nekoliko svetskih gradova bio je poslužen jedan meni za veliki broj zvanica – tačnije: njih 60.000).</p><p>Međutim, restoran Enso će kroz svoj, za ovaj događaj posebno kreniran meni, istaći kulinarsku tradiciju i gastronomske veštine. Osnovu menija čine sveži, sezonski i lokalni proizvodi sa smanjenim procentom masti, šećera, soli i proteina i sa mnogo povrća.</p><p>Međunarodni kulinarski žiri, sastavljen od najvećih svetskih imena, napravio je selekciju i izabrao restorane koji su na spisku zvaničnih, brendiranih gastronomskih tačaka na mapi ovog jedinstvenog, globalnog projekta, a među njima se drugu godinu za redom našao i restoran Enso.</p><p>On se zbog svoje koncepcije, koja počiva na modernoj francuskoj kuhinji, potpuno prirodno uklopio u kulinarski događaj koji će obeležiti mart.</p>', '2019-04-17 18:52:54', '2f41c41d-2ab2-4ec9-ac6d-2e12fba02853.jpg', 0, 0),
(14, 'TobOrg', 6, 'O.U.R. Pub: Češka pivnica u srcu Beograda', '<p>Nekada – O.U.R. Bar, a sada je to O.U.R. Pub. Organizacija udruženog rada ili skraćeno OUR desetak godina je prepoznatljivo ime u Beogradu.</p><p>Upravo je prošlo kroz transformaciju u okviru koje je promenilo koncept. Mnogi za ovo mesto vole da kažu „Our“ (eng. naše) što i jeste želja – da se svi osećaju kao da su na svom terenu i da se uvek tamo vraćaju ponovo.</p><p>Pored sjajnog muzičkog programa (rock, jazz, blues) tokom nedelje, O.U.R. Pub karakterističan je i po autentičnoj atmosferi českih pub-ova po ugledu na koje je i nastao.</p><p>Češka kuhinja sa kreativnim dopunama ostalih zemalja koje neguju pub kulturu, kao i kultura ispijanja piva neizostavni su deo imidža ovog novog-starog mesta u gradu, a neuobičajeno razumne cene su dodatni plus.</p><p>U periodu do Nove godine sredom će biti organizovane jazz svirke, četvrtak će biti rezervisan za akustične nastupe, a petkom će nastupati renomirani cover bendovi, dok će subotom muziku za goste birati različite javne ličnosti u ulozi DJ-eva, poput poznatih muzičara, glumaca, voditelja itd.</p><p>Ove sedmice počev nastupaju sledeći izvođači:</p><p> • <strong>OUR Jazz</strong>: Milan Petrović Quartet (sreda)</p><p> •<strong> OUR Acoustic</strong>: Acoustic Therapy (četvrtak)</p><p> •<strong> OUR Live</strong>: Big Deal (petak)</p><p> •<strong> OUR DJ</strong>: Ognjen Krstić (subota)</p><p>Otvaranjem sveže koncipiranog O.U.R. Pub-a na staroj adresi Beogradska 71, rok, bluz i džez scena u Beogradu dobilaje još jednog saveznika.</p>', '2019-04-17 18:53:42', 'f9b6567f-b1f0-4fd7-acd4-b8138a3c79a9.jpg', 0, 0),
(15, 'TobOrg', 6, 'Upoznaj Srbiju, svrati na Zlatibor!', '<p>Većina domaćih turista je posetila Zlatibor makar jednom u životu, uglavnom tokom školovanja, u okviru rekreativnih nastava i ekskurzija. Međutim, sve je veći broj srpskih turista koji se Zlatiboru vraćaju iznova smatrajući sebe tamo već domaćim.</p><p>Ukoliko niste dugo bili na Zlatiboru, verujte, imaćete šta novo da vidite. Ovo je srpska planina&nbsp;na kojoj se najviše gradi. Čak i ukoliko ste bili prošle ili pre dve godine iznenadiće vas koliko novih hotela, restorana, ali i avanturističkih sadržaja je niklo dok ste bili odsutni.</p><h3>Šta je to što Zlatibor nudi, a nije centar?</h3><p>Zlatibor ima mnogo toga da ponudi svojim posetiocima bilo da su u pitanju domaći ili strani turisti. Bitno je jedno –&nbsp;<strong><em>Zlatibor nije samo centar!</em></strong></p><p>Oni koji često borave na jednoj od najpopularnijih planina u Srbiji vole da kažu kako poznaju Zlatibor kao svoj džep, međutim, taj džep je samo mali deo ogromne putne torbe u koju staju suveniri i uspomene koje traju zauvek.</p>', '2019-04-17 18:54:23', '91d6eb70-ab31-4674-a776-5afe8d2e3f2c.jpg', 0, 0),
(16, 'TobOrg', 6, 'Vikend van Beograda: Zašto baš Niš?', '<p>„Što ideš južnije, to je srcu toplije“&nbsp;– tako bi trebalo da glasi slogan juga naše zemlje. Ovoga puta naš predlog za vikend van Beograda je – Niš.Ako prevlačite prstom po karti Srbije ka jugu, zaustavite ga na tački obeleženoj imenom Niš. Mnogo je razloga zbog kojih bi trebalo to da učinite, a mi ćemo se potruditi da vas u to uverimo u narednim redovima.</p><p>Sigurno ste više puta gledali domaće filmove poput „Zone Zamfirove“, „Ivkove slave“, čitali dela Stevana Sremca koji oslikavaju južnjački mentalitet.</p><p>Mnogima smo se smejali do suza, mnogi su nas rastužili, ali zasigurno je da nas ništa od navedenog nije ostavilo ravnodušnim. Sve je to Niš. Isken osmeh i suze, šala, graja, muzika i odlična hrana, a povrh svega veliki kultnurno-istorijski značaj.</p>', '2019-04-17 18:55:05', '95c9c7c1-d8d3-48eb-af78-f4ea21a9f4ad.jpg', 0, 0),
(17, 'TobOrg', 6, 'Udobno i atraktivno krstarenje Drinom', '<p>Plovidba Drinom ne mora da bude adrenalinska avantura – turistima je na raspolaganju i pravo krstarenje, odnedavno jednim lepim plovilom, turističkim brodom „Grizzly“.</p><p>Ture su na relaciji Perućac – Višegrad – Perućac, duže ili kraće, po izboru. Plovidba do Višegrada, na dužini od 52 kilometra, odvija se najlepšim delom kanjona Drine, onim u kojem se zelenilo četinara spaja sa nestvarnim zelenilom vode, a kamene litice uzdižu i do hiljadu metara u nebo.</p><p>Organizovane su posete Andrićgradu, Višegradu, i čuvenom mostu na Drini kojeg je proslavio Andrićev roman „Na Drini ćuprija“, uz pratnju vodiča, po želji.</p><p>U ponudi je, na primer, i veoma atraktivna plovidba do hidroelektrane „Bajina Bašta“, trasom u dužini od 24 km u jednom pravcu.</p><p>„Grizzly“ je brod katamaranskog tipa, na dva nivoa, kapaciteta 140 mesta. Sve je podređeno uživanju, pa možete da izaberete boravak na palubi ili u zatvorenom salonu, uz laganu muziku, prezentacije na video bimu, napitak, piće, snek, obrok…</p>', '2019-04-17 18:55:42', 'dafe60a8-bff8-4f18-b0fb-5876f9c247c8.jpg', 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_log`
--
ALTER TABLE `admin_log`
  ADD PRIMARY KEY (`id_log`);

--
-- Indexes for table `ankete`
--
ALTER TABLE `ankete`
  ADD PRIMARY KEY (`id_anketa`),
  ADD KEY `kreator` (`kreator`);

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
  ADD PRIMARY KEY (`id_karakteristika`),
  ADD KEY `id_dogadjaj` (`id_dogadjaj`),
  ADD KEY `id_stavka` (`id_stavka`);

--
-- Indexes for table `korisnici`
--
ALTER TABLE `korisnici`
  ADD PRIMARY KEY (`korisnicko_ime`);

--
-- Indexes for table `obavestenja`
--
ALTER TABLE `obavestenja`
  ADD PRIMARY KEY (`id_obavestenje`),
  ADD KEY `korisnicko_ime` (`korisnicko_ime`),
  ADD KEY `idVest` (`id_vest`),
  ADD KEY `idDogadjaj` (`id_dogadjaj`),
  ADD KEY `idOglas` (`id_oglas`);

--
-- Indexes for table `odgovori`
--
ALTER TABLE `odgovori`
  ADD PRIMARY KEY (`id_odgovor`),
  ADD KEY `id_popunjena_anketa` (`id_popunjena_anketa`),
  ADD KEY `id_ponudjeni_odgovor` (`id_ponudjeni_odgovor`);

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
-- Indexes for table `pitanja`
--
ALTER TABLE `pitanja`
  ADD PRIMARY KEY (`id_pitanje`),
  ADD KEY `id_anketa` (`id_anketa`);

--
-- Indexes for table `ponudjeni_odgovori`
--
ALTER TABLE `ponudjeni_odgovori`
  ADD PRIMARY KEY (`id_odgovor`),
  ADD KEY `id_pitanje` (`id_pitanje`);

--
-- Indexes for table `popunjene_ankete`
--
ALTER TABLE `popunjene_ankete`
  ADD PRIMARY KEY (`id_popunjena_anketa`),
  ADD KEY `id_anketa` (`id_anketa`),
  ADD KEY `korisnicko_ime` (`korisnicko_ime`);

--
-- Indexes for table `sifarnici`
--
ALTER TABLE `sifarnici`
  ADD PRIMARY KEY (`id_sifarnik`);

--
-- Indexes for table `sifarnici_izvestaj`
--
ALTER TABLE `sifarnici_izvestaj`
  ADD PRIMARY KEY (`id_sifarnik`);

--
-- Indexes for table `stavke_izvestaj`
--
ALTER TABLE `stavke_izvestaj`
  ADD PRIMARY KEY (`id_stavka`),
  ADD KEY `id_sifarnik` (`id_sifarnik`);

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
-- Constraints for table `ankete`
--
ALTER TABLE `ankete`
  ADD CONSTRAINT `FK_korisnik_anketa` FOREIGN KEY (`kreator`) REFERENCES `korisnici` (`korisnicko_ime`);

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
-- Constraints for table `obavestenja`
--
ALTER TABLE `obavestenja`
  ADD CONSTRAINT `FK_obavestenje_dogadjaj` FOREIGN KEY (`id_dogadjaj`) REFERENCES `dogadjaji` (`id_dogadjaj`),
  ADD CONSTRAINT `FK_obavestenje_korisnik` FOREIGN KEY (`korisnicko_ime`) REFERENCES `korisnici` (`korisnicko_ime`),
  ADD CONSTRAINT `FK_obavestenje_oglas` FOREIGN KEY (`id_oglas`) REFERENCES `oglasi` (`id_oglas`),
  ADD CONSTRAINT `FK_obavestenje_vest` FOREIGN KEY (`id_vest`) REFERENCES `vesti` (`id_vest`);

--
-- Constraints for table `odgovori`
--
ALTER TABLE `odgovori`
  ADD CONSTRAINT `FK_ponudjeni_odgovor_odgovor` FOREIGN KEY (`id_ponudjeni_odgovor`) REFERENCES `ponudjeni_odgovori` (`id_odgovor`),
  ADD CONSTRAINT `FK_popunjena_anketa_odgovor` FOREIGN KEY (`id_popunjena_anketa`) REFERENCES `popunjene_ankete` (`id_popunjena_anketa`);

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
-- Constraints for table `pitanja`
--
ALTER TABLE `pitanja`
  ADD CONSTRAINT `FK_anketa_pitanje` FOREIGN KEY (`id_anketa`) REFERENCES `ankete` (`id_anketa`);

--
-- Constraints for table `ponudjeni_odgovori`
--
ALTER TABLE `ponudjeni_odgovori`
  ADD CONSTRAINT `FK_pitanje_odgovor` FOREIGN KEY (`id_pitanje`) REFERENCES `pitanja` (`id_pitanje`);

--
-- Constraints for table `popunjene_ankete`
--
ALTER TABLE `popunjene_ankete`
  ADD CONSTRAINT `FK_anketa_popunjena_anketa` FOREIGN KEY (`id_anketa`) REFERENCES `ankete` (`id_anketa`),
  ADD CONSTRAINT `FK_korisnik_popunjena_anketa` FOREIGN KEY (`korisnicko_ime`) REFERENCES `korisnici` (`korisnicko_ime`);

--
-- Constraints for table `stavke_izvestaj`
--
ALTER TABLE `stavke_izvestaj`
  ADD CONSTRAINT `FK_sifarnik_izvestaj_stavka_izvestaj` FOREIGN KEY (`id_sifarnik`) REFERENCES `sifarnici_izvestaj` (`id_sifarnik`);

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
