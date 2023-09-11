/* eslint-disable no-underscore-dangle */
import axios from '../../libs/axios';
import configs from '../configs';

import {
  IListUsersReturn,
  IListDropdownReturn,
  IListFAQReturn,
  IGetFAQReturn,
  IListCategoriesFAQReturn,
  ICreateFAQReturn,
  IEditFAQReturn,
  IDeleteFAQReturn,
  ICreateFeedbackReturn,
  IListFeedbackReturn,
  IArchiveFeedbackReturn,
  IChangeLanguageReturn,
} from './types';

const path = `${configs.api_url_user}/${configs.apiVersion}`;

const listUsers = async (filters): Promise<IListUsersReturn> => {
  try {
    const res = await axios.post(`${path}/user/list`, filters, {
      timeout: 300000,
    });

    return {
      data: res.data?.results[0] ? res.data.results[0] : res.data,
      success: true,
    };
  } catch (e: any) {
    return { errorMessage: e.message, success: false };
  }
};

const listDropdown = async (): Promise<IListDropdownReturn> => {
  try {
    const res = await axios.get(`${path}/user/list/filters`);

    return { data: res.data.results[0], success: true };
  } catch (e: any) {
    return { errorMessage: e.message, success: false };
  }
};

const listFAQ = async (body?: any): Promise<IListFAQReturn> => {
  try {
    const res = await axios.get(`${path}/faq/`, {
      params: body,
    });

    return { data: res.data.results, success: true };
  } catch (e: any) {
    return { errorMessage: e.message, success: false };
  }
};

const getFAQ = async (uid: string): Promise<IGetFAQReturn> => {
  try {
    const res = await axios.get(`${path}/faq/${uid}`);

    return { data: res.data.results[0], success: true };
  } catch (e: any) {
    return { errorMessage: e.message, success: false };
  }
};

const listCategoriesFAQ = async (): Promise<IListCategoriesFAQReturn> => {
  try {
    const res = await axios.post(`${path}/faq/categories`);

    return { data: res.data.results || [], success: true };
  } catch (e: any) {
    return { errorMessage: e.message, success: false };
  }
};

const createFAQ = async (body): Promise<ICreateFAQReturn> => {
  try {
    const res = await axios.post(`${path}/faq/create`, body);

    return { data: res.data, success: true };
  } catch (e: any) {
    return { errorMessage: e.message, success: false };
  }
};

const editFAQ = async (uid: string, body: any): Promise<IEditFAQReturn> => {
  try {
    const res = await axios.put(`${path}/faq/edit/${uid}`, body);

    return { data: res.data, success: true };
  } catch (e: any) {
    return { errorMessage: e.message, success: false };
  }
};

const deleteFAQ = async (uid: string): Promise<IDeleteFAQReturn> => {
  try {
    const res = await axios.delete(`${path}/faq/${uid}`);

    return { data: res.data, success: true };
  } catch (e: any) {
    return { errorMessage: e.message, success: false };
  }
};

const createFeedback = async (body): Promise<ICreateFeedbackReturn> => {
  try {
    const res = await axios.post(`${path}/feedback/create`, body);

    return { data: res.data, success: true };
  } catch (e: any) {
    return { errorMessage: e.message, success: false };
  }
};

const listFeedback = async (body?: any): Promise<IListFeedbackReturn> => {
  try {
    const res = await axios.get(`${path}/feedback/`, {
      params: body,
    });

    return { data: res.data.results, success: true };
  } catch (e: any) {
    return { errorMessage: e.message, success: false };
  }
};

const archiveFeedback = async (
  uid: string,
): Promise<IArchiveFeedbackReturn> => {
  try {
    const res = await axios.delete(`${path}/feedback/archive/${uid}`);

    return { data: res.data, success: true };
  } catch (e: any) {
    return { errorMessage: e.message, success: false };
  }
};

const changeLanguage = async (body): Promise<IChangeLanguageReturn> => {
  try {
    const res = await axios.post(`${path}/user/set-preferred-language`, body);

    return { data: res.data, success: true };
  } catch (e: any) {
    return { errorMessage: e.message, success: false };
  }
};

export default {
  listUsers,
  listDropdown,
  listFAQ,
  getFAQ,
  listCategoriesFAQ,
  createFAQ,
  editFAQ,
  deleteFAQ,
  createFeedback,
  listFeedback,
  archiveFeedback,
  changeLanguage,
};
