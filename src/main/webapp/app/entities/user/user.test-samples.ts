import { IUser } from './user.model';

export const sampleWithRequiredData: IUser = {
  id: 17493,
  login: "E`@gzZ8PG\\-1QfD\\VK\\'Uj\\cfeVHB9\\0M3",
};

export const sampleWithPartialData: IUser = {
  id: 6755,
  login: 'w=3va1@7L\\nZZa\\5w3wR8\\WAOcE\\LhOhS\\O2echm',
};

export const sampleWithFullData: IUser = {
  id: 12502,
  login: 'P1u8B',
};
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
