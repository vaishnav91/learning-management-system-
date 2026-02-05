import api from "./axiosConfig";

export const getAllCourses = () => {
  return api.get("/courses");
};

export const createCourse = (course) => {
  return api.post("/courses", course);
};
