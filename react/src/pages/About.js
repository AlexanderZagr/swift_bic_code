import React from 'react'

export const About = () => (
  <div className="jumbotron">
    <div className="container">
      <h1 className="display-10">Довідник SWIFT у клієнт-банку</h1>
      <p className="lead">
        Коди <strong>BIC</strong>, які є в наявності в ОДБ можливо додати до Клієнт-банку 
      </p>
      <p className="lead">
        Для цього потрібно ввести код <strong>BIC</strong> у пошук по довіднику ОДБ,
        вибрати потрібний код , та додати країну.
      </p>
      <p className="lead">
        Країна знаходиться в окремому довіднику в ОДБ, тому її потрібно вибирати окремо 
      </p>
    </div>
  </div>
)
