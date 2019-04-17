-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 17, 2019 at 02:44 AM
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
(1, 'Dodata stavka asdf u šifarnik Kategorije vesti', '2019-04-16 20:02:02'),
(2, 'Dodata stavka asdf u šifarnik Kategorije događaja', '2019-04-16 20:02:08'),
(3, 'Dodata stavka asdf u šifarnik Mesta', '2019-04-16 20:02:12'),
(4, 'Dodata stavka asdf u šifarnik Uzrast', '2019-04-16 20:02:16'),
(5, 'Dodata stavka asdf u šifarnik Ulice', '2019-04-16 20:02:22'),
(6, 'Dodata stavka asd u šifarnik Oblasti delovanja', '2019-04-16 20:02:29'),
(7, 'Dodata stavka asdd u šifarnik Karakteristike prostora', '2019-04-16 20:02:37'),
(8, 'Izmenjen naziv organizacije etf_org', '2019-04-16 20:03:03'),
(9, 'Izmenjen opis organizacije etf_org', '2019-04-16 20:03:06'),
(10, 'Izmenjena oblast delovanja organizacije etf_org', '2019-04-16 20:03:10'),
(11, 'Izmenjena web adresa organizacije etf_org', '2019-04-16 20:03:14'),
(12, 'Izmenjeno mesto organizacije etf_org', '2019-04-16 20:03:18'),
(13, 'Izmenjena ulica organizacije etf_org', '2019-04-16 20:03:18'),
(14, 'Izmenjeni telefoni organizacije etf_org', '2019-04-16 20:03:27'),
(15, 'Izmenjeni telefoni organizacije etf_org', '2019-04-16 20:03:34'),
(16, 'Izmenjen email organizacije etf_org', '2019-04-16 20:03:39'),
(17, 'Arhivirana vest dsadadaa', '2019-04-16 20:07:43'),
(18, 'Obrisana vest dsadadaa', '2019-04-16 20:07:46'),
(19, 'Obrisan oglas Oglas 1', '2019-04-16 20:08:07'),
(20, 'Obrisan događaj Događaj broj 8', '2019-04-16 20:08:27'),
(21, 'Obrisana stavka asdf iz šifarnika Kategorije vesti', '2019-04-17 00:20:59'),
(22, 'Obrisana stavka asd iz šifarnika Oblasti delovanja', '2019-04-17 00:21:25'),
(23, 'Obrisana stavka asdf iz šifarnika Kategorije događaja', '2019-04-17 00:21:30'),
(24, 'Obrisana stavka asdf iz šifarnika Mesta', '2019-04-17 00:21:40'),
(25, 'Obrisana stavka asdf iz šifarnika Uzrast', '2019-04-17 00:21:43'),
(26, 'Obrisana stavka asdf iz šifarnika Ulice', '2019-04-17 00:21:48'),
(27, 'Obrisana stavka asdd iz šifarnika Karakteristike prostora', '2019-04-17 00:21:56'),
(28, 'Odbijen korisnik asdf1', '2019-04-17 00:37:51'),
(29, 'Odobren korisnik asdf12', '2019-04-17 00:38:12'),
(30, 'Odbijen korisnik asdf123', '2019-04-17 00:38:14'),
(31, 'Obrisan korisnik asdf12', '2019-04-17 00:38:20');

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
(1, 'Povratak korenima: Back to Funk u klubu BitefArtCafe', '<p>BitefArtCafe vas poziva na potpuno novi koncept žurki Back To Funk koji će se prvi put održati ovog petka, 25. januara.</p><p>Funk hitove izvodiće uživo James Brown Belgrade Tribute bend, dok će hitove sa ploča vrteti najpopularniji beogradski funky DJ Stefan Novović – DJ Iron.</p><p>Ukoliko ste se uželeli pravih igranki, đuskanja uz najveće soul i funk hitove, ovo je prava vest za vas.</p><p>Beograd je oduvek bio mesto raznolikog noćnog provoda, gde možete da pronađete za svakoga po nešto, reklo bi se – „od Silvane do Nirvane“. Ali, poslednjih godina muzički spektar se sve više deli na dve opcije – veliki broj kafana sa narodnom muzikom sa jedne strane, i veliki broj klubova sa elektronskom muzikom sa druge.</p><p>U međuprostoru nalaze se pojedini lokali koji nude žive svirke domaćih i stranih pop-rock, house i dance hitova. Jedan od takvih klubova je BitefArtCafe koji je ove sezone pokrenuo tematske večeri posvećene <strong>oldschool</strong>, <strong>disco</strong> i <strong>funk</strong> muzici.</p>', 7, 8, 37, 9, '2019-01-25 23:00:01', '2019-01-24 02:47:20', 'etf_org', '2019-01-26 04:00:01', '1.jpg', 0),
(2, 'dadasasddas', '<p>dasdassdasd</p>', 6, 8, 22, 9, '2019-02-01 00:44:40', '2019-01-31 00:44:55', 'ORCA', '2019-02-01 00:44:46', NULL, 0),
(3, 'asdf', '<p>asdf</p>', 7, 8, 22, 9, '2019-02-22 22:00:00', '2019-02-22 21:01:53', 'etf_org', '2019-02-23 12:15:00', NULL, 0),
(5, 'Bullet For My Valentine u Beogradu', '<p>MM Concerts predstavlja:<strong>BULLET FOR MY VALENTINE u Beogradu!</strong></p><p>Svetski poznati metalcore sastav Bullet For My Valentine, nastupiće po prvi put u karijeri&nbsp;u Srbiji, tačnije beogradskom Domu omladine 3. aprila! Svetski poznati metalcore sastav Bullet For My Valentine, nastupiće po prvi put u karijeri&nbsp;u Srbiji, tačnije beogradskom Domu omladine 3. aprila! Svetski poznati metalcore sastav Bullet For My Valentine, nastupiće po prvi put u karijeri&nbsp;u Srbiji, tačnije beogradskom Domu omladine 3. aprila! Svetski poznati metalcore sastav Bullet For My Valentine, nastupiće po prvi put u karijeri&nbsp;u Srbiji, tačnije beogradskom Domu omladine 3. aprila!</p><p>Svetski poznati metalcore sastav Bullet For My Valentine, nastupiće po prvi put u karijeri&nbsp;u Srbiji, tačnije beogradskom Domu omladine 3. aprila!</p><p>Svetski poznati metalcore sastav Bullet For My Valentine, nastupiće po prvi put u karijeri&nbsp;u Srbiji, tačnije beogradskom Domu omladine 3. aprila!</p><p>Svetski poznati metalcore sastav Bullet For My Valentine, nastupiće po prvi put u karijeri&nbsp;u Srbiji, tačnije beogradskom Domu omladine 3. aprila!</p><p>Svetski poznati metalcore sastav Bullet For My Valentine, nastupiće po prvi put u karijeri&nbsp;u Srbiji, tačnije beogradskom Domu omladine 3. aprila!</p><p>Svetski poznati metalcore sastav Bullet For My Valentine, nastupiće po prvi put u karijeri&nbsp;u Srbiji, tačnije beogradskom Domu omladine 3. aprila!</p><p>Svetski poznati metalcore sastav Bullet For My Valentine, nastupiće po prvi put u karijeri&nbsp;u Srbiji, tačnije beogradskom Domu omladine 3. aprila!</p>', 6, 8, 40, 9, '2019-04-03 20:00:00', '2019-02-22 21:03:49', 'etf_org', '2019-04-04 00:00:00', '5.jpg', 0),
(6, 'Dogadjaj broj 1', '<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut varius nulla elit, id ornare metus scelerisque in. Sed quis molestie neque, non tristique ligula. Mauris a tortor augue. In orci mi, pellentesque sodales odio nec, efficitur auctor velit. Pellentesque finibus ante cursus lobortis porttitor. Donec pulvinar sem a mauris condimentum, in dapibus est euismod. Duis aliquet molestie nisi id lobortis. Fusce vel ipsum erat. Aliquam tincidunt dapibus lacus quis hendrerit. Cras non urna feugiat, volutpat lorem vel, efficitur augue. Curabitur volutpat libero ut sapien facilisis, nec sollicitudin lacus fringilla. Nulla ligula risus, auctor pharetra tempor vitae, commodo sit amet nisi. Nunc sagittis vulputate felis quis bibendum. Maecenas pretium enim id mauris eleifend, fermentum bibendum leo tempus. Donec porta orci sit amet mauris imperdiet consectetur.</p>', 6, 8, 22, 9, '2019-05-01 22:00:00', '2019-04-10 03:19:34', 'etf_org', '2019-05-05 11:00:00', NULL, 0),
(7, 'Dogadjaj broj 2', '<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut varius nulla elit, id ornare metus scelerisque in. Sed quis molestie neque, non tristique ligula. Mauris a tortor augue. In orci mi, pellentesque sodales odio nec, efficitur auctor velit. Pellentesque finibus ante cursus lobortis porttitor. Donec pulvinar sem a mauris condimentum, in dapibus est euismod. Duis aliquet molestie nisi id lobortis. Fusce vel ipsum erat. Aliquam tincidunt dapibus lacus quis hendrerit. Cras non urna feugiat, volutpat lorem vel, efficitur augue. Curabitur volutpat libero ut sapien facilisis, nec sollicitudin lacus fringilla. Nulla ligula risus, auctor pharetra tempor vitae, commodo sit amet nisi. Nunc sagittis vulputate felis quis bibendum. Maecenas pretium enim id mauris eleifend, fermentum bibendum leo tempus. Donec porta orci sit amet mauris imperdiet consectetur.</p>', 6, 8, 22, 9, '2019-05-01 22:00:00', '2019-04-10 03:20:36', 'etf_org', '2019-05-01 23:00:00', NULL, 0),
(8, 'Dogadjaj broj 3', '<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut varius nulla elit, id ornare metus scelerisque in. Sed quis molestie neque, non tristique ligula. Mauris a tortor augue. In orci mi, pellentesque sodales odio nec, efficitur auctor velit. Pellentesque finibus ante cursus lobortis porttitor. Donec pulvinar sem a mauris condimentum, in dapibus est euismod. Duis aliquet molestie nisi id lobortis. Fusce vel ipsum erat. Aliquam tincidunt dapibus lacus quis hendrerit. Cras non urna feugiat, volutpat lorem vel, efficitur augue. Curabitur volutpat libero ut sapien facilisis, nec sollicitudin lacus fringilla. Nulla ligula risus, auctor pharetra tempor vitae, commodo sit amet nisi. Nunc sagittis vulputate felis quis bibendum. Maecenas pretium enim id mauris eleifend, fermentum bibendum leo tempus. Donec porta orci sit amet mauris imperdiet consectetur.</p>', 7, 8, 20, 9, '2019-05-01 22:00:00', '2019-04-10 03:21:36', 'etf_org', '2019-05-01 23:00:00', NULL, 0),
(9, 'Dogadjaj broj 4', '<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut varius nulla elit, id ornare metus scelerisque in. Sed quis molestie neque, non tristique ligula. Mauris a tortor augue. In orci mi, pellentesque sodales odio nec, efficitur auctor velit. Pellentesque finibus ante cursus lobortis porttitor. Donec pulvinar sem a mauris condimentum, in dapibus est euismod. Duis aliquet molestie nisi id lobortis. Fusce vel ipsum erat. Aliquam tincidunt dapibus lacus quis hendrerit. Cras non urna feugiat, volutpat lorem vel, efficitur augue. Curabitur volutpat libero ut sapien facilisis, nec sollicitudin lacus fringilla. Nulla ligula risus, auctor pharetra tempor vitae, commodo sit amet nisi. Nunc sagittis vulputate felis quis bibendum. Maecenas pretium enim id mauris eleifend, fermentum bibendum leo tempus. Donec porta orci sit amet mauris imperdiet consectetur.</p>', 10, 44, 45, 9, '2019-08-24 11:00:00', '2019-04-10 03:23:06', 'etf_org', '2019-08-28 04:00:00', NULL, 0),
(10, 'Događaj broj 5', '<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin nisl arcu, viverra in eleifend et, porta vel mauris. Donec sit amet ultrices nisi, quis condimentum lorem. Mauris eu tortor a nisi mattis condimentum. Nam sodales nisl urna, ut dapibus ligula eleifend eu. Proin sollicitudin ante lectus, ut tristique turpis dignissim sit amet. Praesent enim ante, dignissim non porttitor vitae, luctus blandit nisl. Nullam nunc risus, malesuada eget ultrices aliquam, mollis quis arcu. Duis in nisi tincidunt, tempor lacus et, dictum augue. Cras eget lobortis nisl. Fusce arcu mauris, varius in maximus quis, cursus iaculis diam. Integer neque leo, tincidunt sed gravida vel, congue sed neque. Aliquam erat volutpat. Integer elementum semper nisl sed placerat. Nunc vehicula elit quis erat sagittis posuere. Donec tincidunt velit et leo sodales varius.</p><p>Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vivamus eu rhoncus sem, ac porttitor justo. Quisque elit tortor, interdum sed dapibus maximus, fermentum faucibus nunc. Curabitur augue ipsum, sodales sed lorem non, finibus aliquet nunc. Donec hendrerit sem quam. Nullam vestibulum sed nibh at rutrum. Nullam a nisl eu lorem semper tristique in consectetur ex. Nulla facilisi.</p><p>Maecenas sodales orci eu lorem viverra, et ultrices ligula aliquam. Donec lacinia venenatis metus, ac congue orci congue vitae. Mauris ut odio aliquet, dignissim tellus quis, interdum arcu. Mauris eget nibh a eros feugiat ornare vel at elit. Praesent ut odio a nibh vulputate gravida. Aliquam pulvinar cursus convallis. Donec eget tempor enim. Vestibulum sit amet leo ante. Etiam sollicitudin elit et vehicula lobortis. Phasellus quis condimentum tortor, vel elementum nunc. Etiam et massa in nibh tempus bibendum. Nullam vehicula pretium quam suscipit rhoncus. Sed vitae eros sed enim fringilla viverra.</p><p>Duis massa dui, rutrum sed sodales at, imperdiet nec dolor. In non justo pellentesque, feugiat mauris eget, feugiat sem. Vivamus in lacinia tellus. Sed semper erat nisi, mollis mollis turpis accumsan ac. Suspendisse rhoncus lobortis leo id malesuada. Ut porttitor, diam id sollicitudin aliquam, velit magna porta tortor, et ultrices est mauris rutrum neque. Maecenas ultrices nisi eget lacus lacinia, ut suscipit tortor auctor. Praesent eu posuere lacus, non scelerisque eros. Fusce sit amet lacinia augue, et placerat leo. Mauris quis sollicitudin massa.</p><p>Maecenas sagittis elit vel ipsum eleifend, non consectetur mauris pellentesque. In tempus mi pretium nisl lacinia aliquam. Proin non sapien et justo condimentum fringilla. Mauris in nisi sed augue vestibulum maximus. Proin commodo quis ipsum id egestas. Fusce posuere mi maximus risus interdum efficitur. Curabitur quis fringilla mi, ut finibus massa. Integer nec urna gravida, bibendum risus ac, faucibus orci. Nunc augue nisl, porttitor sed vehicula ut, tincidunt eget arcu. Morbi eget sagittis lectus. Sed condimentum tortor ut magna varius porta. In mollis nisi erat, sit amet dignissim ligula convallis vel. Cras pharetra, eros et suscipit mattis, dolor lorem laoreet purus, et eleifend neque eros in ipsum. Nunc venenatis egestas feugiat. Nulla in ante vel elit bibendum iaculis.</p>', 6, 8, 22, 9, '2019-06-01 16:00:00', '2019-04-10 16:46:21', 'etf_org', '2019-06-01 18:00:00', NULL, 0),
(11, 'Događaj broj 6', '<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin nisl arcu, viverra in eleifend et, porta vel mauris. Donec sit amet ultrices nisi, quis condimentum lorem. Mauris eu tortor a nisi mattis condimentum. Nam sodales nisl urna, ut dapibus ligula eleifend eu. Proin sollicitudin ante lectus, ut tristique turpis dignissim sit amet. Praesent enim ante, dignissim non porttitor vitae, luctus blandit nisl. Nullam nunc risus, malesuada eget ultrices aliquam, mollis quis arcu. Duis in nisi tincidunt, tempor lacus et, dictum augue. Cras eget lobortis nisl. Fusce arcu mauris, varius in maximus quis, cursus iaculis diam. Integer neque leo, tincidunt sed gravida vel, congue sed neque. Aliquam erat volutpat. Integer elementum semper nisl sed placerat. Nunc vehicula elit quis erat sagittis posuere. Donec tincidunt velit et leo sodales varius.</p><p>Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vivamus eu rhoncus sem, ac porttitor justo. Quisque elit tortor, interdum sed dapibus maximus, fermentum faucibus nunc. Curabitur augue ipsum, sodales sed lorem non, finibus aliquet nunc. Donec hendrerit sem quam. Nullam vestibulum sed nibh at rutrum. Nullam a nisl eu lorem semper tristique in consectetur ex. Nulla facilisi.</p><p>Maecenas sodales orci eu lorem viverra, et ultrices ligula aliquam. Donec lacinia venenatis metus, ac congue orci congue vitae. Mauris ut odio aliquet, dignissim tellus quis, interdum arcu. Mauris eget nibh a eros feugiat ornare vel at elit. Praesent ut odio a nibh vulputate gravida. Aliquam pulvinar cursus convallis. Donec eget tempor enim. Vestibulum sit amet leo ante. Etiam sollicitudin elit et vehicula lobortis. Phasellus quis condimentum tortor, vel elementum nunc. Etiam et massa in nibh tempus bibendum. Nullam vehicula pretium quam suscipit rhoncus. Sed vitae eros sed enim fringilla viverra.</p><p>Duis massa dui, rutrum sed sodales at, imperdiet nec dolor. In non justo pellentesque, feugiat mauris eget, feugiat sem. Vivamus in lacinia tellus. Sed semper erat nisi, mollis mollis turpis accumsan ac. Suspendisse rhoncus lobortis leo id malesuada. Ut porttitor, diam id sollicitudin aliquam, velit magna porta tortor, et ultrices est mauris rutrum neque. Maecenas ultrices nisi eget lacus lacinia, ut suscipit tortor auctor. Praesent eu posuere lacus, non scelerisque eros. Fusce sit amet lacinia augue, et placerat leo. Mauris quis sollicitudin massa.</p><p>Maecenas sagittis elit vel ipsum eleifend, non consectetur mauris pellentesque. In tempus mi pretium nisl lacinia aliquam. Proin non sapien et justo condimentum fringilla. Mauris in nisi sed augue vestibulum maximus. Proin commodo quis ipsum id egestas. Fusce posuere mi maximus risus interdum efficitur. Curabitur quis fringilla mi, ut finibus massa. Integer nec urna gravida, bibendum risus ac, faucibus orci. Nunc augue nisl, porttitor sed vehicula ut, tincidunt eget arcu. Morbi eget sagittis lectus. Sed condimentum tortor ut magna varius porta. In mollis nisi erat, sit amet dignissim ligula convallis vel. Cras pharetra, eros et suscipit mattis, dolor lorem laoreet purus, et eleifend neque eros in ipsum. Nunc venenatis egestas feugiat. Nulla in ante vel elit bibendum iaculis.</p>', 6, 8, 25, 9, '2019-04-28 00:00:00', '2019-04-10 16:48:31', 'etf_org', '2019-04-29 00:00:00', NULL, 0),
(12, 'Događaj broj 7', '<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin nisl arcu, viverra in eleifend et, porta vel mauris. Donec sit amet ultrices nisi, quis condimentum lorem. Mauris eu tortor a nisi mattis condimentum. Nam sodales nisl urna, ut dapibus ligula eleifend eu. Proin sollicitudin ante lectus, ut tristique turpis dignissim sit amet. Praesent enim ante, dignissim non porttitor vitae, luctus blandit nisl. Nullam nunc risus, malesuada eget ultrices aliquam, mollis quis arcu. Duis in nisi tincidunt, tempor lacus et, dictum augue. Cras eget lobortis nisl. Fusce arcu mauris, varius in maximus quis, cursus iaculis diam. Integer neque leo, tincidunt sed gravida vel, congue sed neque. Aliquam erat volutpat. Integer elementum semper nisl sed placerat. Nunc vehicula elit quis erat sagittis posuere. Donec tincidunt velit et leo sodales varius.</p><p>Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vivamus eu rhoncus sem, ac porttitor justo. Quisque elit tortor, interdum sed dapibus maximus, fermentum faucibus nunc. Curabitur augue ipsum, sodales sed lorem non, finibus aliquet nunc. Donec hendrerit sem quam. Nullam vestibulum sed nibh at rutrum. Nullam a nisl eu lorem semper tristique in consectetur ex. Nulla facilisi.</p><p>Maecenas sodales orci eu lorem viverra, et ultrices ligula aliquam. Donec lacinia venenatis metus, ac congue orci congue vitae. Mauris ut odio aliquet, dignissim tellus quis, interdum arcu. Mauris eget nibh a eros feugiat ornare vel at elit. Praesent ut odio a nibh vulputate gravida. Aliquam pulvinar cursus convallis. Donec eget tempor enim. Vestibulum sit amet leo ante. Etiam sollicitudin elit et vehicula lobortis. Phasellus quis condimentum tortor, vel elementum nunc. Etiam et massa in nibh tempus bibendum. Nullam vehicula pretium quam suscipit rhoncus. Sed vitae eros sed enim fringilla viverra.</p><p>Duis massa dui, rutrum sed sodales at, imperdiet nec dolor. In non justo pellentesque, feugiat mauris eget, feugiat sem. Vivamus in lacinia tellus. Sed semper erat nisi, mollis mollis turpis accumsan ac. Suspendisse rhoncus lobortis leo id malesuada. Ut porttitor, diam id sollicitudin aliquam, velit magna porta tortor, et ultrices est mauris rutrum neque. Maecenas ultrices nisi eget lacus lacinia, ut suscipit tortor auctor. Praesent eu posuere lacus, non scelerisque eros. Fusce sit amet lacinia augue, et placerat leo. Mauris quis sollicitudin massa.</p><p>Maecenas sagittis elit vel ipsum eleifend, non consectetur mauris pellentesque. In tempus mi pretium nisl lacinia aliquam. Proin non sapien et justo condimentum fringilla. Mauris in nisi sed augue vestibulum maximus. Proin commodo quis ipsum id egestas. Fusce posuere mi maximus risus interdum efficitur. Curabitur quis fringilla mi, ut finibus massa. Integer nec urna gravida, bibendum risus ac, faucibus orci. Nunc augue nisl, porttitor sed vehicula ut, tincidunt eget arcu. Morbi eget sagittis lectus. Sed condimentum tortor ut magna varius porta. In mollis nisi erat, sit amet dignissim ligula convallis vel. Cras pharetra, eros et suscipit mattis, dolor lorem laoreet purus, et eleifend neque eros in ipsum. Nunc venenatis egestas feugiat. Nulla in ante vel elit bibendum iaculis.</p>', 6, 21, 46, 9, '2019-09-01 13:00:00', '2019-04-10 16:52:26', 'etf_org', '2019-09-01 17:00:00', NULL, 0);

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
(2, 1, 39),
(3, 5, 39),
(4, 6, 34),
(5, 6, 39),
(6, 6, 43),
(7, 6, 38),
(8, 7, 39),
(9, 8, 38),
(10, 8, 34),
(11, 8, 39),
(12, 9, 34),
(13, 10, 34),
(14, 10, 39),
(15, 10, 43),
(16, 10, 38),
(17, 11, 39),
(18, 11, 34),
(19, 11, 38),
(20, 11, 43),
(21, 12, 38),
(22, 12, 34);

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
('asdf', 0x3a614c432a9de2dcc6ca17acc51cc6a0a5fd529e77381269168e862c208ae92de31725232bd8660b0b6c82bd44775e863687a626a170ea033fa82a7baff8a92f, 0xb315b596ff3a4a5804f58ddd3f5a53c3, 2, 0),
('etf_org', 0x2ecc97f986bc88dff9704aa1caeae3415debba1ebc85f4227c31f9e837f8b5d0a2ce9e0818f884d3412538c08ced6c225953ffe01e1800eaf440335403231215, 0x53a07065c8afb37b995edc2b5b3d63d2, 2, 1),
('nina_org', 0xb009206e47a9ff12b07e4d2b0949b0bafd3b01a41acb54cbf5a746374ec602d59a49dea0b7e466b54cf9b232480fd906944c352b7dd0972f484e365cae43f045, 0xd57097cc3bd46e89c133215fb46634a4, 2, 1),
('ORCA', 0xb5e7d8e57329da237af182ca2257374132df85860ac832bf64a814f89f64d9c922536b904ebec5dee410eccc57db44c3d8d470e38bff4017eda42956d35b5e46, 0x52a7acd395cd5775e2f52594d4acbdac, 2, 1),
('testKorisnik5', 0x64d3eff1e2f3d0c3df8f4df9b882105acef142a6d53142636efcb51d36a34c74dfe61c1347a091fc022bfacd9474e483ca6b18d7a5d9ea227f8bac6270a9241e, 0x4f19f3c2673dadbf34f8f0dc1b19e8c0, 2, 1);

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
(2, 'etf_org', '2019-04-12 21:20:28', 'Korisnik je poslao zahtev za brisanje vesti:', 20, NULL, NULL, 1),
(3, 'etf_org', '2019-04-12 21:20:31', 'Korisnik je poslao zahtev za brisanje vesti:', 19, NULL, NULL, 1),
(4, 'etf_org', '2019-04-12 21:20:36', 'Korisnik je poslao zahtev za brisanje vesti:', 18, NULL, NULL, 1),
(5, 'etf_org', '2019-04-12 21:20:40', 'Korisnik je poslao zahtev za brisanje vesti:', 17, NULL, NULL, 1),
(6, 'etf_org', '2019-04-12 21:20:46', 'Korisnik je poslao zahtev za brisanje vesti:', 16, NULL, NULL, 1),
(8, 'etf_org', '2019-04-12 21:20:55', 'Korisnik je arhivirao vest:', 17, NULL, NULL, 1);

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
(1, 'Java Junior Developer dasgfdsg fasg sgdas fgdhas fghdsa fghas fdghsfd asghd fasghd asgd fasgd fasghdfasghd fasghd fasgd fasghdas fh', '<p>dasdasdas dasd asgdasgd asgdasfgdasfdasg dasgf asgd asgdfasgdas fda ghsd fas gdas fdagsd asd gasdasddasd gas gda ghsd ghasdasdasdasd as das d asdas fgdasd asdas d gas gdd gasd fgasdsdasdasdas fhasdasdas das d adas</p>', '2019-01-26 01:59:05', '2019-01-31 23:59:59', 'etf_org', 1),
(2, 'Advokat', '<h3><strong>Uslovi:</strong></h3><ul<li>Advokati bi trebali vladati prvenstveno privrednim pravom između ostalog, kao i izvršenjima.</li></ul><p><br></p>', '2019-01-27 18:28:18', '2019-01-29 23:59:59', 'ORCA', 0),
(3, 'Lead Software Engineer (Java/.NET)', '<p>Successful candidates will have an opportunity to benefit from:</p><ul><li>Ability to work with most technically gifted people in our industry</li><li>Training package (dedicated working days - approx. 5 % of your time and a matching financial budget)</li><li>Clear career path and defined personal goals with achievement based career prospects</li><li>Permanent contract with competitive salary</li><li>Opportunity to collaborate with colleagues and clients across the Zühlke Group</li><li>asdf</li></ul>', '2019-01-27 23:28:17', '2019-02-10 23:59:59', 'etf_org', 1),
(5, 'Oglas 2', '<p>Lorem ipsum<em><u> dolor sit amet, consectetur adipiscing elit. Duis quis libero tristique, placerat purus aliquet, faucibus ipsum. Donec facilisis porttitor elit, rutrum ornare enim scelerisque pharetra. Donec tempor lectus nibh, vel rhoncus nulla venenatis ut. Nunc gravida malesuada sapien eu egestas. Etiam vitae posuere purus. Mauris urna mauris, blandit ut fringilla ut, sollicitudin vel nisi. Duis eu purus faucibus, fermentum erat quis, rutrum arcu. Pellentesque ut malesuada neque. Nam tempus, lectus id mollis scelerisque, tortor neque </u></em>dapibus orci, ut pellentesque lorem lectus et nulla. Suspendisse in elit malesuada quam dictum tristique. Sed dignissim orci velit, eget lobortis quam pretium vel. Vivamus elementum auctor dignissim. Curabitur semper nisi sed nibh pellentesque sodales quis et lectus. Nunc pulvinar magna eget viverra interdum. Mauris rutrum luctus faucibus.</p><p>Aliquam interdum, diam a rutrum venenatis, ex diam gravida erat, sit amet maximus sem massa quis erat. Phasellus vel justo feugiat, consectetur tellus sit amet, ornare sapien. Donec dictum semper mauris at volutpat. Vestibulum ornare ex id erat aliquam, vel porta quam vehicula. Maecenas mi neque, auctor in efficitur a, cursus dapibus mauris. Donec nulla magna, ultrices at tempus ut, faucibus id leo. Nulla vehicula mi mollis tellus ullamcorper malesuada. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nunc finibus, metus non ornare consequat, ante ligula dictum libero, a molestie quam tortor vitae nisi. Praesent et placerat massa, posuere varius erat. Nulla erat odio, aliquet sed consectetur a, placerat sit amet neque.</p><p>Sed tristique, justo sit amet lobortis scelerisque, nunc libero vestibulum libero, id tempor sem magna ac sem. Cras ante purus, vehicula in erat in, accumsan hendrerit nulla. Integer vel pulvinar ante. Vivamus in ligula et eros dignissim consectetur ac quis ante. In eget sollicitudin arcu, tempor ultrices nibh. Sed in diam quis libero imperdiet rutrum. Sed nibh nulla, eleifend sit amet imperdiet eget, rhoncus eu magna. Nam id venenatis nunc, eu egestas massa. Cras varius pellentesque magna, pretium luctus odio efficitur vel. Praesent ut libero in elit dignissim ullamcorper. Vestibulum at malesuada purus.</p><p>Proin pellentesque erat sit amet commodo pulvinar. Mauris sodales libero at ultrices sodales. Praesent nunc ligula, viverra eget tempus vel, pharetra scelerisque sem. Aenean sed feugiat mi, ut faucibus metus. Vestibulum non erat neque. Sed imperdiet purus at mauris volutpat, imperdiet condimentum ante tempus. Sed ultrices mi libero, et cursus nulla suscipit a.</p>', '2019-04-10 20:35:36', '2019-07-19 23:59:59', 'etf_org', 0),
(6, 'Oglas 3', '<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis quis libero tristique, placerat purus aliquet, faucibus ipsum. Donec facilisis porttitor<strong><em><u> elit, rutrum ornare enim scelerisque pharetra. Donec tempor lectus nibh, vel rhoncus nulla venenatis ut. Nunc gravida malesuada sapien eu egestas. Etiam vitae posuere purus. Mauris urna mauris, blandit ut fringilla ut, sollicitudin vel nisi. Duis eu purus faucibus, fermentum erat quis, rutrum arcu. Pellentesque ut malesuada neque. Nam tempus, lectus id mollis scelerisque, tortor neque dapibus orci, ut pellentesque lorem lectus et nulla. Suspendisse in elit malesuada quam dictum tristique. Sed dignissim orci velit, eget lobortis quam pretium vel. Vivamus elementum auctor dignissim. Curabitur semper nisi sed nibh pellentesque sodales quis et lectus. Nunc pulvinar magna eget viverra interdum. Mauris rutrum luctus faucibus.</u></em></strong></p><p><strong><em><u>Aliquam interdum, diam a rutrum venenatis, ex diam gravida erat, sit amet maximus sem massa quis erat. Phasellus vel justo feugiat, consectetur tellus sit amet, ornare sapien. Donec dictum semper mauris at volutpat. Vestibulum ornare ex id erat aliquam, vel porta quam vehicula. Maecenas mi neque, auctor in efficitur a, cursus dapibus mauris. Donec nulla magna, ultrices at tempus ut, faucibus id leo. Nulla vehicula mi mollis tellus ullamcorper malesuada. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nunc finibus, metus non ornare consequat, ante ligula dictum libero, a molestie quam tortor vitae nisi. Praesent et placerat massa, posuere varius erat. Nulla erat odio, aliquet sed consectetur a, placerat sit amet neque.</u></em></strong></p><p><strong><em><u>Sed tristique, justo sit amet lobortis scelerisque, nunc libero vestibulum libero, id tempor sem magna ac sem. Cras ante purus, vehicula in erat in, accumsan hendrerit nulla. Integer vel pulvinar ante. Vivamus in ligula et eros dignissim consectetur ac quis ante. In eget sollicitudin arcu, tempor ultrices nibh. </u></em></strong>Sed in diam quis libero imperdiet rutrum. Sed nibh nulla, eleifend sit amet imperdiet eget, rhoncus eu magna. Nam id venenatis nunc, eu egestas massa. Cras varius pellentesque magna, pretium luctus odio efficitur vel. Praesent ut libero in elit dignissim ullamcorper. Vestibulum at malesuada purus.</p><p>Proin pellentesque erat sit amet commodo pulvinar. Mauris sodales libero at ultrices sodales. Praesent nunc ligula, viverra eget tempus vel, pharetra scelerisque sem. Aenean sed feugiat mi, ut faucibus metus. Vestibulum non erat neque. Sed imperdiet purus at mauris volutpat, imperdiet condimentum ante tempus. Sed ultrices mi libero, et cursus nulla suscipit a.</p>', '2019-04-10 20:35:58', '2019-08-17 23:59:59', 'etf_org', 0),
(7, 'Oglas 4', '<ul><li>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis quis libero tristique, placerat purus aliquet, faucibus ipsum. Donec facilisis porttitor elit, rutrum ornare enim scelerisque pharetra. Donec tempor lectus nibh, vel rhoncus nulla venenatis ut. Nunc gravida malesuada sapien eu egestas. Etiam vitae posuere purus. Mauris urna mauris, blandit ut fringilla ut, sollicitudin vel nisi. Duis eu purus faucibus, fermentum erat quis, rutrum arcu. Pellentesque ut malesuada neque. Nam tempus, lectus id mollis scelerisque, tortor neque dapibus orci, ut pellentesque lorem lectus et nulla. Suspendisse in elit malesuada quam dictum tristique. Sed dignissim orci velit, eget lobortis quam pretium vel. Vivamus elementum auctor dignissim. Curabitur semper nisi sed nibh pellentesque sodales quis et lectus. Nunc pulvinar magna eget viverra interdum. Mauris rutrum luctus faucibus.</li><li>Aliquam interdum, diam a rutrum venenatis, ex diam gravida erat, sit amet maximus sem massa quis erat. Phasellus vel justo feugiat, consectetur tellus sit amet, ornare sapien. Donec dictum semper mauris at volutpat. Vestibulum ornare ex id erat aliquam, vel porta quam vehicula. Maecenas mi neque, auctor in efficitur a, cursus dapibus mauris. Donec nulla magna, ultrices at tempus ut, faucibus id leo. Nulla vehicula mi mollis tellus ullamcorper malesuada. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nunc finibus, metus non ornare consequat, ante ligula dictum libero, a molestie quam tortor vitae nisi. Praesent et placerat massa, posuere varius erat. Nulla erat odio, aliquet sed consectetur a, placerat sit amet neque.</li><li>Sed tristique, justo sit amet lobortis scelerisque, nunc libero vestibulum libero, id tempor sem magna ac sem. Cras ante purus, vehicula in erat in, accumsan hendrerit nulla. Integer vel pulvinar ante. Vivamus in ligula et eros dignissim consectetur ac quis ante. In eget sollicitudin arcu, tempor ultrices nibh. Sed in diam quis libero imperdiet rutrum. Sed nibh nulla, eleifend sit amet imperdiet eget, rhoncus eu magna. Nam id venenatis nunc, eu egestas massa. Cras varius pellentesque magna, pretium luctus odio efficitur vel. Praesent ut libero in elit dignissim ullamcorper. Vestibulum at malesuada purus.</li><li>Proin pellentesque erat sit amet commodo pulvinar. Mauris sodales libero at ultrices sodales. Praesent nunc ligula, viverra eget tempus vel, pharetra scelerisque sem. Aenean sed feugiat mi, ut faucibus metus. Vestibulum non erat neque. Sed imperdiet purus at mauris volutpat, imperdiet condimentum ante tempus. Sed ultrices mi libero, et cursus nulla suscipit a.</li></ul>', '2019-04-10 20:36:28', '2019-04-27 23:59:59', 'etf_org', 0),
(8, 'Oglas 5', '<ol><li>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis quis libero tristique, placerat purus aliquet, faucibus ipsum. Donec facilisis porttit<strong><u>or elit, rutrum ornare enim scelerisque pharetra. Donec tempor lectus nibh, vel rhoncus nulla venenatis ut. Nunc gravida malesuada sapien eu egestas. Etiam vitae posuere purus. Mauris urna mauris, blandit ut fringilla ut, sollicitudin vel nisi. Duis eu purus faucibus, fermentum erat quis, rutrum arcu. Pellentesque ut malesuada neque. Nam tempus, lectus id mollis scelerisque, tortor neque dapibus orci, ut pellentesque lorem lectus et nulla. Suspendisse in elit malesuada quam dictum tristique. Sed dignissim orci velit, eget lobortis quam pretium vel. Vivamus elementum auctor dignissim. Curabitur semper nisi sed nibh pellentesque sodales quis et lectus. Nunc pulvinar magna eget viverra interdum. Mauris rutrum luctus faucibus.</u></strong></li><li><strong><u>Aliquam interdum, diam a rutrum venenatis, ex diam gravida erat, sit amet maximus sem massa quis erat. Phasellus vel justo feugiat, consectetur tellus sit amet, ornare sapien. Donec dictum semper mauris at volutpat. Vestibulum ornare ex id erat aliquam, vel porta quam vehicula. Maecenas mi neque, auctor in efficitur a, cursus dapibus mauris. Donec nulla magna, ultrices at tempus ut, faucibus id leo. Nulla vehicula mi mollis tellus ullamcorper malesuada. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nunc finibus, metus non ornare consequat, ante ligula dictum libero, a molestie quam tortor vitae nisi. Praesent et placerat massa, posuere varius erat. Nulla erat odio, aliquet sed consectetur a, placerat sit amet neque.</u></strong></li><li><strong><u>Sed tristique, justo sit amet lobortis scelerisque, nunc libero vestibulum libero, id tempor sem magna ac sem. Cras ante purus, vehicula in erat in, accumsan hendrerit nulla. Integer vel pulvinar ante. Vivamus in ligula et eros dignissim consectetur ac quis ante. In eget sollicitudin arcu, tempor ultrices nibh. </u></strong>Sed in diam quis libero imperdiet rutrum. Sed nibh nulla, eleifend sit amet imperdiet eget, rhoncus eu magna. Nam id venenatis nunc, eu egestas massa. Cras varius pellentesque magna, pretium luctus odio efficitur vel. Praesent ut libero in elit dignissim ullamcorper. Vestibulum at malesuada purus.</li></ol><p>Proin pellentesque erat sit amet commodo pulvinar. Mauris sodales libero at ultrices sodales. Praesent nunc ligula, viverra eget tempus vel, pharetra scelerisque sem. Aenean sed feugiat mi, ut faucibus metus. Vestibulum non erat neque. Sed imperdiet purus at mauris volutpat, imperdiet condimentum ante tempus. Sed ultrices mi libero, et cursus nulla suscipit a.</p>', '2019-04-10 20:37:06', '2019-04-30 23:59:59', 'etf_org', 0),
(9, 'Oglas 1 ORCA', '<h3>Lorem ipsum dolor sit amet, consectetur adipiscing elit. </h3><h3>Duis quis libero tristique, placerat purus aliquet, faucibus ipsum. Donec facilisis porttitor elit, rutrum ornare enim scelerisque pharetra. Donec tempor lectus nibh, vel rhoncus nulla venenatis ut. Nunc gravida malesuada sapien eu egestas. Etiam vitae posuere purus. Mauris urna mauris, blandit ut fringilla ut, sollicitudin vel nisi. Duis eu purus faucibus, fermentum erat quis, rutrum arcu. Pellentesque ut malesuada neque. Nam tempus, lectus id mollis scelerisque, tortor neque dapibus orci, ut pellentesque lorem lectus et nulla. Suspendisse in elit malesuada quam dictum tristique. Sed dignissim orci velit, eget lobortis quam pretium vel. Vivamus elementum auctor dignissim. Curabitur semper nisi sed nibh pellentesque sodales quis et lectus. Nunc pulvinar magna eget viverra interdum. Mauris rutrum luctus faucibus.</h3><p>Aliquam interdum, diam a rutrum venenatis, ex diam gravida erat, sit amet maximus sem massa quis erat. Phasellus vel justo feugiat, consectetur tellus sit amet, ornare sapien. Donec dictum semper mauris at volutpat. Vestibulum ornare ex id erat aliquam, vel porta quam vehicula. Maecenas mi neque, auctor in efficitur a, cursus dapibus mauris. Donec nulla magna, ultrices at tempus ut, faucibus id leo. Nulla vehicula mi mollis tellus ullamcorper malesuada. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nunc finibus, metus non ornare consequat, ante ligula dictum libero, a molestie quam tortor vitae nisi. Praesent et placerat massa, posuere varius erat. Nulla erat odio, aliquet sed consectetur a, placerat sit amet neque.</p><p>Sed tristique, justo sit amet lobortis scelerisque, nunc libero vestibulum libero, id tempor sem magna ac sem. Cras ante purus, vehicula in erat in, accumsan hendrerit nulla. Integer vel pulvinar ante. Vivamus in ligula et eros dignissim consectetur ac quis ante. In eget sollicitudin arcu, tempor ultrices nibh. Sed in diam quis libero imperdiet rutrum. Sed nibh nulla, eleifend sit amet imperdiet eget, rhoncus eu magna. Nam id venenatis nunc, eu egestas massa. Cras varius pellentesque magna, pretium luctus odio efficitur vel. Praesent ut libero in elit dignissim ullamcorper. Vestibulum at malesuada purus.</p><p>Proin pellentesque erat sit amet commodo pulvinar. Mauris sodales libero at ultrices sodales. Praesent nunc ligula, viverra eget tempus vel, pharetra scelerisque sem. Aenean sed feugiat mi, ut faucibus metus. Vestibulum non erat neque. Sed imperdiet purus at mauris volutpat, imperdiet condimentum ante tempus. Sed ultrices mi libero, et cursus nulla suscipit a.</p>', '2019-04-10 20:38:16', '2019-04-29 23:59:59', 'ORCA', 0);

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
('asdf', 'asdsa', 'asdf', 'asdf@gmail.com', 'dadsa', 31, 'http://dsada', 8, 22, '0601844575'),
('etf_org', 'Elektrotehnički fakultet Univerziteta u Beograduu', 'Nina Grujić', 'opsta_sluzba@etf.bg.ac.rss', 'Raazvoj Elektrotehničkog fakulteta u bliskoj je vezi sa istorijom univerzitetskog obrazovanja u Srbiji. Prvo visokoškolsko predavanje iz oblasti elektrotehnike održano je davne 1894. Profesor Stevan Marković bio je prvi predavač i osnivač Elektrotehničke katedre Inženjerskog odeljenja Velike škole u Beogradu. Stevan Marković Samo četiri godine kasnije, profesor Marković je osnovao i elektroinženjersku laboratoriju. Od tada, elektrotehničke teme su se izučavale na Velikoj školi, a zatim i na beogradskom Univerzitetu koji je iz nje nastao 1905. Prve diplome dodeljene su 1922 godine.', 17, 'http://www.etf.bg.ac.rss', 8, 67, '0113226760, 0601844595'),
('nina_org', 'Ninina organizacija', 'Nina Grujić', 'ninaorg@gmail.com', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque imperdiet dui at magna hendrerit aliquet. Ut consectetur scelerisque orci, non faucibus nunc laoreet eget. Aenean condimentum nisl a tortor faucibus, non malesuada nisl rhoncus. Nam non bibendum est. Sed aliquam elit non mauris dapibus, eu vestibulum libero consectetur. Proin nec urna dui. Nulla sed nisi nec ex cursus vulputate interdum vel augue. Pellentesque suscipit faucibus lorem. Aenean ultricies a purus in bibendum. In id erat vitae augue posuere pharetra. Maecenas augue orci, scelerisque vestibulum nulla at, mattis rutrum massa. Curabitur maximus lorem ac eros hendrerit, in rutrum nisi suscipit. Sed nisl risus, ornare non est non, fringilla rhoncus magna. Praesent posuere fermentum orci, sit amet dapibus sem. Donec sodales, nunc sed placerat hendrerit, quam ante luctus felis, a commodo urna augue id justo.', 17, 'http://www.mojaorg.com', 8, 22, '0601844595'),
('ORCA', 'ORCA', 'Dragana Taaar', 'info@orca.rs', 'ORCA je organizacija civilnog društva koja pomaže ljudima u Srbiji i na Zapadnom Balkanu da brinu o prirodi i dobrobiti životinja kako bi ostvarili lični, ekonomski i društveni razvoj.\n\nSvoju misiju ostvarujemo kroz javno zastupanje, istraživanje, obrazovanje i praćenje primene politika i propisa. Kroz javno zastupanje, utičemo na usvajanje boljih zakona, njihovo sprovođenje i promenu kulture društva u odnosu na prirodu i životinje.', 31, 'http://www.orca.rs', 8, 32, '0112438653'),
('testKorisnik5', 'testKorisnik3', 'Test Korinisnik', 'testkorisni3@gmail.com', 'tesko korisnik 3', 17, 'http://www.mojaorg.com', 8, 22, '0601844595');

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
(12, 'Obrisane stavke');

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
(1, 'Kategorije vesti: asdf', '2019-04-16 20:02:02', 11),
(2, 'Kategorije događaja: asdf', '2019-04-16 20:02:08', 11),
(3, 'Mesta: asdf', '2019-04-16 20:02:12', 11),
(4, 'Uzrast: asdf', '2019-04-16 20:02:16', 11),
(5, 'Ulice: asdf', '2019-04-16 20:02:22', 11),
(6, 'Oblasti delovanja: asd', '2019-04-16 20:02:29', 11),
(7, 'Karakteristike prostora: asdd', '2019-04-16 20:02:37', 11),
(8, 'Ulice: Bulevar Kralja Aleksandra 74', '2019-04-16 20:03:18', 11),
(9, 'dsadadaa', '2019-04-16 20:07:43', 5),
(10, 'dsadadaa', '2019-04-16 20:07:46', 6),
(11, 'Oglas 1', '2019-04-16 20:08:07', 10),
(12, 'Događaj broj 8', '2019-04-16 20:08:27', 8),
(13, 'asdf', '2019-04-16 20:10:28', 4),
(14, 'Kategorije vesti: asdf', '2019-04-17 00:20:59', 12),
(15, 'Oblasti delovanja: asd', '2019-04-17 00:21:25', 12),
(16, 'Kategorije događaja: asdf', '2019-04-17 00:21:30', 12),
(17, 'Mesta: asdf', '2019-04-17 00:21:40', 12),
(18, 'Uzrast: asdf', '2019-04-17 00:21:43', 12),
(19, 'Ulice: asdf', '2019-04-17 00:21:48', 12),
(20, 'Karakteristike prostora: asdd', '2019-04-17 00:21:56', 12),
(21, 'asdf', '2019-04-17 00:33:01', 1),
(22, 'asdf1', '2019-04-17 00:33:06', 1),
(23, 'asdf12', '2019-04-17 00:33:09', 1),
(24, 'asdf123', '2019-04-17 00:33:11', 1),
(25, 'asdf', '2019-04-17 00:36:21', 2),
(26, 'asdf1', '2019-04-17 00:37:51', 2),
(27, 'asdf123', '2019-04-17 00:38:14', 2),
(28, 'asdf12', '2019-04-17 00:38:19', 3),
(29, 'asdf', '2019-04-17 01:45:44', 1);

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
(1, 1, 'Muzika', '6966c125-8a3d-4706-8db7-fe73da29466c.png'),
(2, 1, 'Film', '570209ed-ecd4-49d1-a550-c8ba32182508.png'),
(4, 1, 'Pozorište', 'bf0726b1-93ec-4e57-846c-8ff934f1ef5e.png'),
(5, 1, 'Izložbe', '35596cc1-a944-4da4-9662-34da43391a13.png'),
(6, 2, 'Koncert', NULL),
(7, 2, 'Clubbing', NULL),
(8, 3, 'Beograd', NULL),
(9, 4, '18+', NULL),
(10, 2, 'Festival', NULL),
(11, 2, 'Projekcija', NULL),
(12, 2, 'Sajam', NULL),
(13, 2, 'Radionica', NULL),
(14, 2, 'Predstava', NULL),
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
(34, 7, 'Besplatan parking', 'e91606a4-9c82-4dca-b071-2f10852d12e0.png'),
(36, 5, 'Cvijićeva 29', NULL),
(37, 5, 'Mitropolita Petra 8', NULL),
(38, 7, 'Podrška invalidima', '8276ecee-c8da-4339-805c-4adf9ac176cd.jpg'),
(39, 7, 'WiFi', '033925a8-e5e8-4f14-b028-61a16728ef69.png'),
(40, 5, 'Makedonska 22', NULL),
(41, 1, 'Festivali', 'fa83674c-def8-4101-8317-62a5657603ca.png'),
(42, 2, 'Izložba', NULL),
(43, 7, 'Pet friendly', '3f9b538b-cf4b-491b-80cb-85c92a5b58b0.png'),
(44, 3, 'Guča', NULL),
(45, 5, 'Krsmadinska 13', NULL),
(46, 5, 'Moše Pijade 18', NULL),
(47, 5, 'Knez Mihajlova 5', NULL),
(54, 5, 'Visnjicka 12', NULL),
(55, 5, 'Visnjicka 13', NULL),
(56, 5, 'Visnjicka 14', NULL),
(57, 5, 'Visnjicka 15', NULL),
(58, 5, 'Visnjicka 16', NULL),
(59, 5, 'Visnjicka 17', NULL),
(67, 5, 'Bulevar Kralja Aleksandra 74', NULL);

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
(1, 'nina_org', 1, 'GO Novi Beograd: Besplatni novogodišnji paketići za decu', '<p>Za mališane uzrasta do 12 godina biće pripremljeni besplatni novogodišnji paketići koje će Opština Novi Beograd podeliti tokom novogodišnjih praznika.</p><p>Kao i godinama unazad, deca sa Novog Beograda koju roditelji prijave dobiće svoj besplatni paketić u, sada već dobro poznatoj, novogodišnjoj atmosferi koju opština Novi Beograd sa ponosom tradicionalno priređuje za najmlađe sugrađane.</p>', '2018-11-27 12:00:00', NULL, 0, 0),
(2, 'nina_org', 2, 'Da umor ne pokvari sve', '<p>Rasprodaje i slave, praznici i specijalni zimski događaji, planovi za izlet i boravak na planini manje prijaju kad je umor koji osećate konstantan, a vi ne znate kako da ga se oslobodite.</p><p>Da li vam se čini da drugi više uživaju, više se raduju, emituju mnogo pozitivne energije, dok se vi poslednjim atomima snage trudite da ne zaostanete, i ne pokažete koliko vam je sve teško pada? U izvesnim godinama umor je očekivan i toleriše se kao tema, ali u nekim drugim, mlađim, to ne bi trebalo da bude.</p>', '2018-11-27 14:00:00', NULL, 0, 0),
(3, 'nina_org', 4, 'VIII Plesni susreti u DKCB', '<p>U subotu, 24. novembra, na sceni „Donka Špiček“ Dečjeg kulturnog centra Beograd počeće „Plesni susreti“ članova plesnih studija za decu i mlade sa teritorije Beograda.</p><p>Revija baletskih i plesnih studija sastoji se od dva koncerta (11.00 i 15.00).</p><p>Plesni susreti osnovani su 2015. godine sa idejom da se afirmiše dečje plesno stvaralaštvo, predstavi rad koreografa koji rade sa decom i omogući razmena iskustava među plesnim pedagozima.</p>', '2018-11-27 21:00:00', NULL, 0, 0),
(4, 'nina_org', 1, 'Pre Beth Hart nastupiće Mr. Swagger, Pera Joe i Katarina Pejak', '<p>Jedna od najboljih bluz-rok pevačica današnjice Beth Hart nastupiće u Hali sportova a gosti na koncertu su Mr. Swagger, Pera Joe i Katarina Pejak.</p>', '2018-11-27 18:24:00', NULL, 0, 0),
(5, 'nina_org', 5, 'IV Funk kongres u Beogradu', '<p>U subotu, 15. decembra od 20.00, na poslednjem spratu kule Ušće (Top Of The Hub) biće otvoren međunarodni IV Funk kongres u Beogradu.</p>', '2018-11-27 20:16:00', NULL, 0, 0),
(6, 'nina_org', 1, 'SubBeerni centar: Zabranjeno pušenje ovog četvrtka', '<p>U četvrtak, 29. novembra od 20.00, Zabranjeno pušenje će održati veliki koncert u klubu Subbeerni centar u Cetinjskoj 15.</p><p>Time će promovisati svoj novi, jedanaesti album „Šok i nevjerica“, koji je objavljen 31. oktobra i dostupan za preuzimanje na</p>', '2018-11-28 10:00:00', NULL, 0, 0),
(7, 'nina_org', 1, 'Mando Diao – energija, vatra i strast u Beogradu!', '<p>U petak, 7. decembra od 20.00, švedska indi rok grupa Mando Diao nastupiće prvi put u Beogradu, u Hali sportova „Ranko Žeravica“.</p>', '2018-11-28 13:00:00', NULL, 0, 0),
(8, 'nina_org', 1, 'Musicology: Keziah Jones sinoć oduvao publiku', '<p>Harizmatični pevač i gitarista poreklom iz Nigerije, Keziah Jones, nastupio je sinoć sa svojim bendom, 28. novembra, u sklopu koncertnog serijala Musicology.</p><p>U prepunom klubu Novi Bitefartcafe, Keziah Jones je još jednom dokazao da su njegovi koncerti jedinstveno iskustvo i oduvao publiku energičnom svirkom i spontanim performansom. Ovo je bio prvi od dva koncerta, a Keziah će po drugi put nastupiti u petak, 30. novembra, na istom mestu.</p><p>Karata za ovaj koncert je ostalo jako malo, pa bi trebalo požuriti do najbližeg prodajnog mesta Eventima ili DDtickets ili ulaznice kupiti preko njihovih sajtova.</p><p>Među prvim pesmama na koncertu našla se „Kpafuca“, a publika je od samog starta prihvatila poziv na ples i ostatak koncerta provela pevajući i plešući u transu uz nigerijskog blufank princa.</p>', '2018-12-02 02:29:00', NULL, 0, 0),
(9, 'nina_org', 1, 'Dom omladine Beograda: The Tiger Lillies', '<p>U ponedeljak, 3. decembra od 21.00, u Velikoj sali Doma omladine Beograda koncert će održati britanski kamerni kabare trio The Tiger Lillies.</p><p>Ulaznice su u pretprodaji po ceni od 1200 RSD, preko Eventim mreže.</p><p>The Tiger Lillies spada u one specijalne pojave na globalnoj muzičkoj sceni koje nikoga ne ostavljaju ravnodušnim – uglavnom ih zavolite za sva vremena onog časa kad se upoznate sa njihovim pesmama, u kojima žive i nekako preživljavaju svi gubitnici koje možete zamisliti.</p><p>Mornari, prosjaci, prostitutke, zelenaši i drugi džeparoši, nesrećni ljudi čije se sudbine umetnički opisuju i proživljaju u jednom vodvilju što kroz songove opisuje dno sveta, kao da je u pitanju najbolji dramski tekst.</p><p>Kombinujući elemente cirkuske i ciganske muzike, atmosferu predratnog Berlina, motive iz „Opere za 3 groša“ – sa savremenim temama, The Tiger Lilies su stvorili autentičan umetnički pristup na granici pozorišnog i muzičkog izraza, koji nema svog pandana na sceni.</p>', '2018-12-02 06:00:00', NULL, 0, 0),
(10, 'nina_org', 1, 'Neviđena „Rok opera“ u Beogradu', '<p>Koncert koji je izazvao pažnju i za koji se traži karta više je „Rok opera“. Nešto što na sceni Sava centra i u Beogradu još nije viđeno…</p><p>Obilje koncertnih aktivnosti, karakteristično je za kraj godine. Publika u Beogradu svakodnevno može da bira kom će se muzičkom žanru prikloniti.</p><p>Uglavnom, na sceni su izvođači od kojih znamo šta nas očekuje. Međutim, o koncertu „Rok opera“ sigurno će se dugo pričati.</p><p>Dirigent i aranžer Fedor Vrtačnik uspeo je da osmisli program koji 27. novembra od 20.30, nikog neće ostaviti ravnodušnim. Više od 120 izvođača – novosadski Big Bend i članovi hora i opere Srpskog narodnog pozorišta, na sceni će izvesti 20 antologijskih rok hitova.</p><p>Organizatori su prezadovoljni, jer je publika u Beogradu i Srbiji prepoznala kvalitet ove muzičke priče. Svima koji su na samom početku mislili da je jedan ovakav projekat prevelik zalogaj, samo nekoliko dana pred koncert, jasno je da će ovo biti pravo osveženje u moru „već viđenih“ koncerata.</p><p>Konačno će i publika u glavnom gradu čuti i videti zašto je ova kombinacija dva, naizgled nespojiva muzička pravca, opčinila publiku u Novom Sadu, Zrenjaninu, na Paliću i u Crnoj Gori, gde je koncertu na otvorenom prisustvovalo više od 3000 ljudi.</p>', '2018-12-02 00:00:00', NULL, 0, 0),
(11, 'nina_org', 1, 'Parobrod: Starogradska muzika u savremenom aranžmanu', '<p>U petak, 23. novembra od 19.30, UK „Parobrod“ pokreće seriju akustičnih koncerata „Starogradska muzika – muzika Starog grada“ koju otvara bend On Tour.</p><p>Već narednog dana u subotu, 24. novembra od 19.00, seriju koncerata nastavlja Dukat Stray Dogg.</p><p>U ovom ciklusu od deset koncerata nastupiće najbolji domaći autori akustične muzike i uz redovni autorski repertoar, specijalno dorćolskom komšiluku u čast, odsviraće po najmanje jedan hit starogradske muzike u sopstvenoj obradi.Za dž</p><p>Direktor Ustanove kulture Starog grada Milutin Petrović komentarisao je projekat „Starogradska muzika – muzika Starog grada“:</p>', '2018-12-02 00:16:00', NULL, 0, 0),
(12, 'nina_org', 1, 'Jesenji Odjeci Beogradskog Šopen festa: U slavu Poljske', '<p>Tradicionalni kulturni program Jesenji Odjeci 7. Beogradskog Šopen festa biće održan u ponedeljak, 26. novembra od 18.00, u sali Jevrejske opštine (Kralja Petra 71a).</p><p>Šopen fest i Ambasada Poljske organizuju muzičko-poetsko veče sa pratećom istorijskom izložbom „Očevi nezavisnosti“.</p><p>Dela Betovena, Lista, Šopena i Paderevskog, izvešće pijanističke zvezde u usponu Lazar Torbica i Dragana Teparić.</p><p>Devetnaestogodišnji pijanista iz Šapca, Lazar Torbica, student je druge godine Akademije umetnosti u Novom Sadu, u klasi renomirane pijanistkinje i prof. Rite Kinke. Dobitnik je više od 40 nagrada na domaćim i međunarodnim takmičenjima.</p><p>Pijanistkinja sa karijerom u usponu, Dragana Teparić diplomirala je i završila master studije na FMU. Dobitnici je najznačajnijih nagrada i laureat je takmičenja u zemlji i inostranstvu.</p><p>Kao gosti večeri, nastupiće studenti Departmana drame FSU, Đorđe Jovičić, Nađa Ristić i Lazar Tešić i govoriće poeziju poljskih pesnika. Koordinator poetskog programa je prof. Biljana Đurović.</p>', '2018-12-02 00:15:00', NULL, 0, 0),
(13, 'nina_org', 1, 'SKC: Oleg Kirejev i džez 1960-tih', '<p>U petak, 30. novembra od 20.00, u Studentskom kulturnom centru nastupiće saksofonista Oleg Kirejev koji će predstaviti džez šezdesetih.</p><p>To je zlatni period super zvezda o kojima i do danas kruže legende. Velikani Čarli Parker i Džon Koltrejn su već izveli svoje muzičke revolucije i inicirali nove stilove; Majls Dejvis je već proglašen za velikog muzičara, a budući titani Kit Džeret i Čik Korija su započeli svoj uspon.</p><p>Na desetine ogranaka, eksperimenti, eksplozija novih ideja… Šezdesete godine su ispunjene inspiracijom, slobodom i novim mislima. Kul džez, bosa-nova i, naravno, tradicionalni džez – sve to ćete moći da čujete na koncertu Olega Kirejeva i njegovog ansambla.</p><p>Oleg Kirejev je priznati saksofonista koji je izvanredno upoznat sa tom epohom i ne samo na rečima. Oleg je bio učenik samog Bada Šenka, poznatog predstavnika „west coast“ džeza.</p>', '2018-12-02 05:00:00', NULL, 0, 0),
(14, 'nina_org', 1, 'Koncert: Neno Belan & Fiumens sviraju pesme Đavola', '<p>U četvrtak, 22. novembra od 21.00, u sali Amerikana Doma omladine Beograda Neno Belan & Fiumens sviraće pesme legendarne splitske grupe Đavoli.</p><p>– To je poseban koncert koji ću posvetiti opusu moje nekadašnje grupe Đavoli. Taj format zovemo double retro show jer nas vraća u slatki zvuk šezdesetih. Neće to biti običan koncert nego pravi muzičko-scenski događaj – najavljuje Neno Belan.</p><p>Koncert „Neno Belan & Fuimens sviraju pesme grupe Đavoli“ posvećen je jednoj od najvažnijih rok grupa na prostoru bivše Jugoslavije, jedinstvenoj i prepoznatljivoj po mešavini ranog rokenrola i tvista uz specifičan mediteranski ‘začin’ i razrađen imidž.</p><p>Neno Belan & Fiumens uživo će proći kroz sva četiri studijska albuma Đavola objavljena od 1986. do 1998. godine: „Ljubav i moda“, „Halo Lulu 22“, „Ostani uz mene“ i „Space Twist“.</p>', '2018-12-01 13:06:00', NULL, 0, 0),
(16, 'etf_org', 1, 'sdadsadasada', '<p>dasdasdassada aa sdas dvas</p><p>dadasdas dgaf dagdfas h</p>', '2019-02-15 03:32:23', '16.jpeg', 0, 1),
(17, 'etf_org', 2, 'fgffh', '<p>gg dfd f dgf fgfg</p><p>gd fd f f fg</p>', '2019-02-15 03:48:02', NULL, 1, 1),
(18, 'etf_org', 1, 'adsdasdsada dgasd faghdfagdf agdfa gdfagdf adfagdfaghd agdfaghdfagdfa hdfagdf agdf agdf agdfagdfagdfagd fagdf aghd aghdfaghd fagdf aghdf agdfashgdfa gsh', '<p>dasdadasdasdas dgasdasgdas</p><p>dasdas dafdga sdasfd</p><ol><li>asdf</li><li>asdf2</li><li>asdf3</li></ol>', '2019-02-15 03:49:49', '18.jpg', 0, 1),
(19, 'etf_org', 1, 'ssASAdasdsadasadad', '<h1>sdasdasdsdsdsad</h1><p>dasdsadsd sgdfsa dfsdsadfasd asdagsd <u>fagsdf </u>agh dfhag dga dagh da</p><p>dasd <em>afdasgdfasdasdagdfggads</em></p><p>dasd afdadad asf f dad asfd agd a <strong>da</strong></p><ul><li><strong>ddasd</strong></li><li><strong>dasdasdd</strong></li><li><strong>dasdsaas</strong></li></ul>', '2019-02-15 03:50:46', '19.jpg', 0, 1),
(20, 'etf_org', 1, 'dasdsadas', '<p>sadsadadasdasd</p>', '2019-04-05 23:05:08', NULL, 1, 1),
(21, 'etf_org', 1, 'asdf', '<p>dsadad</p>', '2019-04-16 20:10:28', NULL, 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_log`
--
ALTER TABLE `admin_log`
  ADD PRIMARY KEY (`id_log`);

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
