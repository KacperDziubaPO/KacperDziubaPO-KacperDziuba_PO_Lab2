-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 12 Sty 2022, 07:32
-- Wersja serwera: 10.4.22-MariaDB
-- Wersja PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `librarydb`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `books`
--

CREATE TABLE `books` (
  `book_Id` int(100) NOT NULL,
  `author` varchar(60) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `releaseDate` date DEFAULT NULL,
  `avaliable` binary(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `books`
--

INSERT INTO `books` (`book_Id`, `author`, `title`, `releaseDate`, `avaliable`) VALUES
(1, 'Mickiewicz', 'Tadeusz', '2000-10-10', 0x31),
(4, 'Sapkowski', 'Krew elfów', '1998-10-10', 0x31),
(5, 'Lovecraft', 'Zew Cthulu', '1980-10-10', 0x31),
(6, 'Ernest Hemingway', 'Stary człowiek i morze', '1930-10-10', 0x31),
(7, 'Bolesław Prus', 'Lalka', '1910-10-10', 0x31),
(9, 'Jacek Komuda', 'Samozwaniec', '2000-10-10', 0x31),
(10, 'Wiliam Szekspir', 'Romeo i Julia', '1990-10-10', 0x31),
(11, 'Sienkiewicz', 'Trylogia', '1980-10-10', 0x31);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `borrowers`
--

CREATE TABLE `borrowers` (
  `borrower_id` int(100) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `secondname` varchar(30) DEFAULT NULL,
  `Pesel` double(11,0) DEFAULT NULL,
  `libCardNumber` int(5) DEFAULT NULL,
  `phoneNumb` int(9) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  `priviliges` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `borrowers`
--

INSERT INTO `borrowers` (`borrower_id`, `name`, `secondname`, `Pesel`, `libCardNumber`, `phoneNumb`, `password`, `priviliges`) VALUES
(6, 'Leon', 'Dyk', 0, 1111, 111222333, 'user', 'BOR'),
(8, 'Pracownik', 'Biblioteki', 1, 1, 0, 'Librarian1', 'LIB'),
(15, 'Ola', 'Kot', 12345678901, 1471, 123123123, 'OLKO901', 'BOR'),
(16, 'Jan', 'Dyk', 12345678902, 9668, 123123121, 'JADY902', 'BOR');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `loans`
--

CREATE TABLE `loans` (
  `loan_id` int(100) NOT NULL,
  `borrower_Id` int(100) DEFAULT NULL,
  `book_Id` int(100) DEFAULT NULL,
  `issuedDate` date DEFAULT NULL,
  `returnDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `loans`
--

INSERT INTO `loans` (`loan_id`, `borrower_Id`, `book_Id`, `issuedDate`, `returnDate`) VALUES
(1, 6, 1, '2022-01-12', '2022-02-02');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`book_Id`);

--
-- Indeksy dla tabeli `borrowers`
--
ALTER TABLE `borrowers`
  ADD PRIMARY KEY (`borrower_id`);

--
-- Indeksy dla tabeli `loans`
--
ALTER TABLE `loans`
  ADD PRIMARY KEY (`loan_id`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `books`
--
ALTER TABLE `books`
  MODIFY `book_Id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT dla tabeli `borrowers`
--
ALTER TABLE `borrowers`
  MODIFY `borrower_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT dla tabeli `loans`
--
ALTER TABLE `loans`
  MODIFY `loan_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
