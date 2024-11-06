import { IAuthority, NewAuthority } from './authority.model';

export const sampleWithRequiredData: IAuthority = {
  name: 'ff2224e5-9d25-41fc-8ccb-c2a894aa82a2',
};

export const sampleWithPartialData: IAuthority = {
  name: '4bbf5485-a311-43bd-b448-c5c94eae5329',
};

export const sampleWithFullData: IAuthority = {
  name: '48a74b08-4622-4dc4-943e-5b9f6740a074',
};

export const sampleWithNewData: NewAuthority = {
  name: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
