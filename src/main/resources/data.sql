DROP TABLE IF EXISTS books, users, cart;

	CREATE TABLE books (
	  bid INT AUTO_INCREMENT  PRIMARY KEY,
	  author_name VARCHAR(250) NOT NULL,
	  title VARCHAR(250) NOT NULL,
	  genre VARCHAR(250) NOT NULL,
	  price INT NOT NULL
	);

CREATE TABLE cart (
                       bid INT AUTO_INCREMENT  PRIMARY KEY,
                       author_name VARCHAR(250),
                       title VARCHAR(250),
                       genre VARCHAR(250),
                       price INT,
                       status varchar(250)
);

	CREATE TABLE users (
	  uid long AUTO_INCREMENT  PRIMARY KEY,
	  username VARCHAR(250),
	  password VARCHAR(250));

	INSERT INTO books (author_name,title, genre, price) VALUES
	  ('Peter Maas','Valachi Papers', 'History', 10),
	  ('Joe Pistone', 'Donnie Brasco', 'History', 15),
	  ('Annie Jacobson', 'Pentagons Brain', 'History',10),
	  ('Marcus Aurelius', 'Meditations', 'Philosophy',15),
	  ('Thomas Rid', 'Rise of the Machines', 'History',24),
      ('John Norwich', 'Byzantium Vol 1', 'History', 30),
      ('John Norwich', 'Byzantium Vol 2', 'History', 30),
      ('John Norwich', 'Byzantium Vol 3', 'History', 30),
	  ('Seneca', 'Letters from a Stoic', 'Philosophy', 20),
	  ('Ryan Holliday', 'Daily Stoic', 'Philosophy', 15);

	  INSERT INTO users (username, password) VALUES
	  ('admin','admin'), ('Guest', 'default');