--1
DROP TABLE IF EXISTS singles;
--2
CREATE TABLE Singles(Single VARCHAR(100) NOT NULL, Artist VARCHAR(50) NOT NULL, Label VARCHAR(50) NOT NULL, Year INT NOT NULL, Sales BIGINT NOT NULL, PRIMARY KEY(Single, Artist));
--3
INSERT INTO singles("single", "artist", "label", "year", "sales")  VALUES('Something About the Way You Look Tonight / Candle in the Wind 1997', 'Elton John', 'Rocket',1997,4950898), ('Do They Know Its Christmas?', 'Band Aid', 'Mercury', 1984, 3943060), ('Shape of You', 'Ed Sheeran', 'Asylum/Atlantic', 2017, 3006404), ('Bohemian Rhapsody', 'Queen', 'EMI', 1975, 2795034), ('Uptown Funk', 'Mark Ronson featuring Bruno Mars', 'Columbia-Sony-RCA',2014, 2723470), ('Happy', 'Pharell Williams', 'Back Lot Music-i Am Other-Columbia', 2013,2629657), ('Thinking Out Loud', 'Ed Sheeran', 'Asylum-Atlantic', 2014, 2521302), ('One Dance', 'Drake featuring Wizkid & Kyla', 'Young Money-Cash Money-Republic', 2016, 2344981), ('Rather Be', 'Clean Bandit featuring Jess Glyne', 'Atlantic', 2014, 2218697), ('Sorry', 'Justin Bieber', 'Def Jam', 2015, 2167907) ;
--4
SELECT * FROM singles ORDER BY year DESC;
--5
ALTER TABLE singles ADD month VARCHAR(50) DEFAULT 'January'; 
--6
UPDATE singles SET month = 'September' WHERE artist LIKE '%Elton John%'; 
--7
SELECT single, year, sales FROM singles WHERE artist = 'Ed Sheeran' ORDER BY sales DESC;
--8
SELECT artist, single, year FROM singles WHERE label LIKE '%Atlantic%' ORDER BY year ASC;
