/**
 * @Author oussama hrita
 * @Date 31/01/2023
 * @Description creation of the brTransport database
 */
 
/* Création de la base de données brTransport */
DROP DATABASE IF EXISTS brTransport;
CREATE DATABASE brTransport;
USE brTransport;

/* user table */
DROP TABLE IF EXISTS user;
CREATE TABLE `user`(
    `user_id` int NOT NULL AUTO_INCREMENT,
    `genre` varchar(10) NOT NULL,
    `nom` varchar(30) NOT NULL,
    `prenom` varchar(30) NOT NULL,
    `telephone` varchar(10) NOT NULL,
    `adresse` varchar(200) NOT NULL,
    `Email` varchar(50) NOT NULL UNIQUE,
    `password` varchar(30) NOT NULL,
    PRIMARY KEY(`user_id`)
);
/* responsable table */
DROP TABLE IF EXISTS responsable;
CREATE TABLE `responsable`(
    `responsable_id` int NOT NULL AUTO_INCREMENT,
    `cin` varchar(20) NOT NULL,
    `genre` varchar(10) NOT NULL,
    `nom` varchar(30) NOT NULL,
    `prenom` varchar(30) NOT NULL,
    `Email` varchar(50) NOT NULL,
    `password` varchar(30) NOT NULL,
    PRIMARY KEY(`responsable_id`)
);
/* Facture table */
DROP TABLE IF EXISTS lieu;
CREATE TABLE `lieu`(
    `lieu_id` int NOT NULL AUTO_INCREMENT,
    `lieu1` varchar(30) NOT NULL,
    `lieu2` varchar(30) NOT NULL,
    `distance` double NOT NULL,
     PRIMARY KEY(`lieu_id`)
);
/* Opération table */
DROP TABLE IF EXISTS operation;
CREATE TABLE `operation`(
    `operation_id` int NOT NULL AUTO_INCREMENT,
    `status` varchar(30) NOT NULL,
    `user_id` int,
    `lieu_id` int,
    PRIMARY KEY(`operation_id`),
    FOREIGN KEY(`user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(`lieu_id`) REFERENCES `lieu`(`lieu_id`) ON DELETE CASCADE ON UPDATE CASCADE
);
/* marchandise table */
DROP TABLE IF EXISTS marchandise;
CREATE TABLE `marchandise`(
    `marchandise_id` int NOT NULL AUTO_INCREMENT,
    `hauteur` double NOT NULL,
    `largeur` double NOT NULL,
    `longueur` double NOT NULL,
    `poids` double NOT NULL,
    `type` varchar(30) NOT NULL,
    `operation_id` int,
    PRIMARY KEY(`marchandise_id`),
    FOREIGN KEY(`operation_id`) REFERENCES `operation`(`operation_id`) ON DELETE CASCADE ON UPDATE CASCADE
);
/* Facture table */
DROP TABLE IF EXISTS facture;
CREATE TABLE `facture`(
    `facture_id` int NOT NULL AUTO_INCREMENT,
    `prix` double NOT NULL,
    `description` varchar(100) NOT NULL,
    `operation_id` int,
    PRIMARY KEY(`facture_id` ),
    FOREIGN KEY(`operation_id`) REFERENCES `operation`(`operation_id`) ON DELETE CASCADE ON UPDATE CASCADE
);
DROP TABLE IF EXISTS contact;
CREATE TABLE `contact`(
    `id` int NOT NULL AUTO_INCREMENT,
     `nom` varchar(20) NOT NULL,
    `prenom` varchar(20) NOT NULL,
    `email` varchar(50) NOT NULL,
    `sujet` varchar(50) NOT NULL,
    `message` varchar(500) NOT NULL,
    `vue` int,
    PRIMARY KEY(`id`)
);