CREATE DATABASE IF NOT EXISTS `fmail_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `fmail_db`;
CREATE TABLE IF NOT EXISTS `domains` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(50) DEFAULT NULL,
    `active` tinyint(1) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE IF NOT EXISTS `aliases` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `source` varchar(100) DEFAULT NULL,
    `destination` text,
    `active` tinyint(1) DEFAULT NULL,
    `domain_id` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `domain_id` (`domain_id`),
    CONSTRAINT `aliases_ibfk_1` FOREIGN KEY (`domain_id`) REFERENCES `domains` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE IF NOT EXISTS `users` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `email` varchar(50) NOT NULL,
    `nom` varchar(50) NOT NULL,
    `prenom` varchar(50) NOT NULL,
    `password` varchar(60) NOT NULL,
    `active` tinyint(1) NOT NULL,
    `domaine_id` int(11) DEFAULT NULL,
    `birthday` date NOT NULL,
    `is_admin` tinyint(1) DEFAULT 0,
    PRIMARY KEY (`id`),
    UNIQUE KEY `email` (`email`),
    KEY `domaine_id` (`domaine_id`),
    CONSTRAINT `users_ibfk_1` FOREIGN KEY (`domaine_id`) REFERENCES `domains` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS inbox (
    id int(11) NOT NULL AUTO_INCREMENT,
    `from` varchar (50) NOT NULL,
    `to` varchar (50) NOT NULL,
    `message` MESSAGE_TEXT ,
    `subject` varchar (50) NOT NULL,
    `created_at` date not null,
    `deletedAt` DATE
);