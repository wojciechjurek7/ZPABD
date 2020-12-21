INSERT INTO users (username, password, enabled)
  values ('user','$2a$10$nMed8QDSZEHcBdU9LuqqHu9WhARFxowEXMH5Fv9Mp5eLQXJmsGlEm', 1);
INSERT INTO users (username, password, enabled)
  values ('admin','$2a$10$Yv6mmYa2cP943pwovG8hF.0eDzewAI7TEdo8q35p4UQt9VrM6uzB.', 1);
INSERT INTO users (username, password, enabled)
  values ('guest','$2a$10$PbBndLZqhnicP24PdAhAsOgmNG4TwXSE0Rd.MpdRXDKGdwPENBSzC', 1);
  
INSERT INTO authorities (username, authority) values ('user', 'USER');
INSERT INTO authorities (username, authority) values ('guest', 'GUEST');
INSERT INTO authorities (username, authority) values ('admin', 'ADMIN');