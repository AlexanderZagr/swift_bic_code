import React, {useReducer} from 'react'
import axios from 'axios'
import {AccordbaseContext} from './accordbaseContext'
import {accordbaseReducer} from './accordbaseReducer'
import {SELECT_COUNTRY_CODE,
  ADD_BIC,
  FETCH_COUNTRY,
  FETCH_BICSWIFT, 
  SHOW_LOADER} from '../types'

// адрес по которому обращаемся , в файле .env.LOCAl
// http://ib-tst:8080/auth-accord-idoc 
const url = process.env.REACT_APP_DB_URL_ACCORD

export const AccordbaseState = ({children}) => {
  const initialState = {
    countries: [],
    bicswifts :[],
    countryCode :0,
    resultAddBic :'',
    loading: false
  }
  const [state, dispatch] = useReducer(accordbaseReducer, initialState)
  //
  const showLoader = () => dispatch({type: SHOW_LOADER})

  //список стран
  const fetchCountries = async () => {
    showLoader()
    const res = await axios.get(`${url}/swift/swiftCountry`)
    //преобразовали результат в payload
    const payload = Object.keys(res.data.result).map(key => {
      return {
        ...res.data.result[key],
        id: key
      }
    })
   //добавили результат запроса в state  - countries
    dispatch({type: FETCH_COUNTRY, payload})
  }

  //список кодов из ОДБ по поисковому слову bic
  const fetchBicSwift = async title => {
   showLoader()
   const res = await axios.get(`${url}/swift/swiftBic`,{
      params: {
        bic: title
      }
    })

    if (res.data.result==null){
      res.data.result=[]
    }
   // список BIC из ОДБ
   //const payload=[]
   //if (!Array.isArray(res.data.result)) {
   // alert ("!!!")
   //} else {
     const payload = Object.keys(res.data.result).map(key => {
      return {
        ...res.data.result[key],
        id: key
      }
    })
 // }
     //добавили результат запроса в state  - bicswifts
     dispatch({type: FETCH_BICSWIFT, payload})
    }


  //добавить код в клиент-банк  
  const addBic= async (newBic) => {

     const res = await axios.post(`${url}/swift/addSwift`, newBic)
           const payload = {
        ...newBic,
         id: res.data.result
      }
      
      dispatch({type: ADD_BIC,payload: payload}) 
  }

  //Запоминаем выбранную страну в state, чтобы потом добавить ее в  BIC ДЛЯ клиент-банк
  const selectCountryCode = async id => {
     dispatch({
      type: SELECT_COUNTRY_CODE,
      payload: id
    })
  }

  
  return (
    <AccordbaseContext.Provider value={{
      showLoader,  fetchCountries, fetchBicSwift, addBic,selectCountryCode,
      loading: state.loading,
      countries: state.countries,
      countryCode: state.countryCode,
      bicswifts :state.bicswifts,
      resultAddBic :state.resultAddBic
    }}>
      {children}
    </AccordbaseContext.Provider>
  )
}
