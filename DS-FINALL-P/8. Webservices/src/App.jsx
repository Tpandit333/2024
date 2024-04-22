import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import { TableOne } from './TableOne';

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <TableOne />
    </>
  )
}

export default App
