import api from "./axiosConfig";

export const getAllUsers = () => {
  return api.get("/users");
};

export const createUser = (user) => {
  return api.post("/users", user);
};
