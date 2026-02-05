import api from "./axiosConfig";

export const getLessons = (moduleId) =>
  api.get(`/lessons/module/${moduleId}`);

export const addLesson = (moduleId, lesson) =>
  api.post(`/lessons/${moduleId}`, lesson);
