-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 29, 2018 at 05:07 PM
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
  `uzrast` int(11) NOT NULL,
  `datum_dogadjaja` datetime NOT NULL,
  `datum_kreiranja` datetime NOT NULL,
  `korisnicko_ime` varchar(50) NOT NULL,
  `datum_isticanja` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dogadjaji`
--

INSERT INTO `dogadjaji` (`id_dogadjaj`, `naslov`, `tekst`, `kategorija`, `mesto`, `uzrast`, `datum_dogadjaja`, `datum_kreiranja`, `korisnicko_ime`, `datum_isticanja`) VALUES
(1, 'Boris Brejchaaaa', 'Boris BrejchaaaaBoris BrejchaaaaBoris BrejchaaaaBoris BrejchaaaaBoris BrejchaaaaBoris BrejchaaaaBoris BrejchaaaaBoris BrejchaaaaBoris BrejchaaaaBoris BrejchaaaaBoris BrejchaaaaBoris BrejchaaaaBoris BrejchaaaaBoris Brejchaaaa', 6, 8, 9, '2018-11-30 22:00:00', '2018-11-29 17:00:00', 'nina_grujic', '2018-12-01 04:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `korisnici`
--

CREATE TABLE `korisnici` (
  `korisnicko_ime` varchar(50) NOT NULL,
  `lozinka` varchar(50) NOT NULL,
  `tip` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `korisnici`
--

INSERT INTO `korisnici` (`korisnicko_ime`, `lozinka`, `tip`) VALUES
('nina_grujic', 'debd3328', 2);

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
(4, 'uzrast');

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
(9, 4, '18+', NULL);

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
(1, 'nina_grujic', 1, 'GO Novi Beograd: Besplatni novogodišnji paketići za decu', 'Za mališane uzrasta do 12 godina biće pripremljeni besplatni novogodišnji paketići koje će Opština Novi Beograd podeliti tokom novogodišnjih praznika.\r\n\r\nKao i godinama unazad, deca sa Novog Beograda koju roditelji prijave dobiće svoj besplatni paketić u, sada već dobro poznatoj, novogodišnjoj atmosferi koju opština Novi Beograd sa ponosom tradicionalno priređuje za najmlađe sugrađane.', '2018-11-27 12:00:00', '1.jpg', 0),
(2, 'nina_grujic', 2, 'Da umor ne pokvari sve', 'Rasprodaje i slave, praznici i specijalni zimski događaji, planovi za izlet i boravak na planini manje prijaju kad je umor koji osećate konstantan, a vi ne znate kako da ga se oslobodite.\r\n\r\nDa li vam se čini da drugi više uživaju, više se raduju, emituju mnogo pozitivne energije, dok se vi poslednjim atomima snage trudite da ne zaostanete, i ne pokažete koliko vam je sve teško pada? U izvesnim godinama umor je očekivan i toleriše se kao tema, ali u nekim drugim, mlađim, to ne bi trebalo da bude.', '2018-11-27 14:00:00', '2.jpg', 0),
(3, 'nina_grujic', 4, 'VIII Plesni susreti u DKCB', 'U subotu, 24. novembra, na sceni „Donka Špiček“ Dečjeg kulturnog centra Beograd počeće „Plesni susreti“ članova plesnih studija za decu i mlade sa teritorije Beograda.\r\n\r\nRevija baletskih i plesnih studija sastoji se od dva koncerta (11.00 i 15.00).\r\n\r\nPlesni susreti osnovani su 2015. godine sa idejom da se afirmiše dečje plesno stvaralaštvo, predstavi rad koreografa koji rade sa decom i omogući razmena iskustava među plesnim pedagozima.', '2018-11-27 21:00:00', '3.jpg', 0),
(4, 'nina_grujic', 1, 'Pre Beth Hart nastupiće Mr. Swagger, Pera Joe i Katarina Pejak', 'Jedna od najboljih bluz-rok pevačica današnjice Beth Hart nastupiće u Hali sportova a gosti na koncertu su Mr. Swagger, Pera Joe i Katarina Pejak.', '2018-11-27 18:24:00', '4.jpg', 0),
(5, 'nina_grujic', 5, 'IV Funk kongres u Beogradu', 'U subotu, 15. decembra od 20.00, na poslednjem spratu kule Ušće (Top Of The Hub) biće otvoren međunarodni IV Funk kongres u Beogradu.', '2018-11-27 20:16:00', '5.jpg', 0),
(6, 'nina_grujic', 1, 'SubBeerni centar: Zabranjeno pušenje ovog četvrtka', 'U četvrtak, 29. novembra od 20.00, Zabranjeno pušenje će održati veliki koncert u klubu Subbeerni centar u Cetinjskoj 15.\r\n\r\nTime će promovisati svoj novi, jedanaesti album „Šok i nevjerica“, koji je objavljen 31. oktobra i dostupan za preuzimanje na', '2018-11-28 10:00:00', '6.jpg', 0),
(7, 'nina_grujic', 1, 'Mando Diao – energija, vatra i strast u Beogradu!', 'U petak, 7. decembra od 20.00, švedska indi rok grupa Mando Diao nastupiće prvi put u Beogradu, u Hali sportova „Ranko Žeravica“.', '2018-11-28 13:00:00', '7.jpg', 0);

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
  ADD KEY `korisnicko_ime` (`korisnicko_ime`);

--
-- Indexes for table `korisnici`
--
ALTER TABLE `korisnici`
  ADD PRIMARY KEY (`korisnicko_ime`);

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
  ADD CONSTRAINT `FK_uzrast_dogadjaj` FOREIGN KEY (`uzrast`) REFERENCES `stavke_sifarnika` (`id_stavka`);

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
