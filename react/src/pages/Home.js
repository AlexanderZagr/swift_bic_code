import React, {Fragment, useContext, useEffect} from 'react'
import {Form} from '../components/Form'
import {FormBicSwift} from '../components/FormBicSwift'
import {Notes} from '../components/Notes'
import {BicSwifts} from '../components/BicSwifts'
import {SelectCountry} from '../components/SelectCountry'
import {FirebaseContext} from '../context/firebase/firebaseContext'
import {AccordbaseContext} from '../context/accord/accordbaseContext'
import {Loader} from '../components/Loader'

export const Home = () => {
  const {loading} = useContext(FirebaseContext)
  const {addBic, countries, bicswifts,fetchCountries,fetchBicSwift } = useContext(AccordbaseContext)
  useEffect(() => {
    fetchCountries()
    fetchBicSwift()
    // eslint-disable-next-line
  }, [])

  return (
    <Fragment>
      <FormBicSwift/>
      <hr/>
       {loading
        ? <Loader />: <BicSwifts bicswifts={bicswifts} countries={countries} onAddBic={addBic}   />
      }
      
    </Fragment>  
  )
}
