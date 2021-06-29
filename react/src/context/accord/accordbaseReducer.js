import {FETCH_COUNTRY, FETCH_BICSWIFT, SELECT_COUNTRY_CODE, ADD_BIC,SHOW_LOADER} from '../types'

const handlers = {
  [SHOW_LOADER]: state => ({...state, loading: true}),
  [FETCH_COUNTRY]: (state, {payload}) => 
     ({...state, countries: payload, loading: false}),
  [FETCH_BICSWIFT]: (state, {payload}) => 
   ({...state, bicswifts: payload, loading: false}),
  [SELECT_COUNTRY_CODE]: (state, {payload}) => 
  ({...state, countryCode: payload}),
  [ADD_BIC]: (state, {payload}) => 
  ({  ...state, resultAddBic : payload
  }),
 
  DEFAULT: state => state
}

export const accordbaseReducer = (state, action) => {
  const handle = handlers[action.type] || handlers.DEFAULT
  return handle(state, action)
}
