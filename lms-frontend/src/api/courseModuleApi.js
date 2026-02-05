import api from "./axiosConfig";

export const getModules = (courseId) =>
  api.get(`/modules/course/${courseId}`);

export const addModule = (courseId, module) =>
  api.post(`/modules/${courseId}`, module);
