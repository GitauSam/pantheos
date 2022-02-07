import React, { useEffect, useState } from 'react'
import CustomerDataService from '../services/customer.service'
import Table from '@mui/material/Table'
import TableBody from '@mui/material/TableBody'
import TableCell from '@mui/material/TableCell'
import TableContainer from '@mui/material/TableContainer'
import TableHead from '@mui/material/TableHead'
import TableRow from '@mui/material/TableRow'
import Paper from '@mui/material/Paper'
import Box from '@mui/material/Box'
import TextField from '@mui/material/TextField'
import Button from '@mui/material/Button'
import Alert from '@mui/material/Alert'
import Stack from '@mui/material/Stack'

const CustomerList = () => {
    const [customers, setCustomers] = useState(null)
    const [country, setCountry] = useState("")
    const [phoneState, setPhoneState] = useState("")
    const [errorOccurred, setErrorOccurred] = useState(false)
    const [errorMessage, setErrorMessage] = useState("")

    const fetchCustomers = () => {
        CustomerDataService
            .getAllCustomers()
            .then(response => {
                console.log(response)
                if (response.data.code === '200') {
                    setCustomers(response.data.data)
                    setErrorOccurred(false)
                } else {
                    console.log(response.data.message)
                    setErrorMessage(response.data.message)
                    setErrorOccurred(true)
                }
            })
            .catch(e => {
                console.log(e)
                setErrorMessage("Unknown error occurred")
                setErrorOccurred(true)
            })
    }

    const filterCustomers = (c, p) => {
        CustomerDataService
            .getFilteredCustomers(c, p)
            .then(response => {
                console.log(response)
                if (response.data.code === '200') {
                    setCustomers(response.data.data)
                    setErrorOccurred(false)
                } else {
                    console.log(response.data.message)
                    setErrorMessage(response.data.message)
                    setErrorOccurred(true)
                }
            })
            .catch(e => {
                console.log(e)
                setErrorMessage("Unknown error occurred")
                setErrorOccurred(true)
            })
    }

    useEffect(() => {
        fetchCustomers()
    }, [])

    return <>
            {errorOccurred && 
                <Stack sx={{ width: '100%' }} spacing={2}>
                    <Alert severity="error">{errorMessage}</Alert>
                </Stack>
            }
            <div className="Filter-section">
                <Box
                    component="form"
                    sx={{
                        '& > :not(style)': { m: 1, width: '25ch' },
                    }}
                    noValidate
                    autoComplete="off"
                    >
                    <TextField 
                        label="Country" 
                        color="secondary" 
                        onChange={(e) => {
                            setCountry(e.target.value)
                        }}
                    />
                    <TextField 
                        label="State" 
                        color="secondary" 
                        onChange={(e) => {
                            setPhoneState(e.target.value)
                        }}
                    />
                    <Button 
                        variant="contained"
                        onClick={() => {
                            filterCustomers(country, phoneState)
                        }}
                    >
                        Filter
                    </Button>
                </Box>
            </div>
            <TableContainer component={Paper}>
                <Table sx={{ minWidth: 650 }} aria-label="simple table">
                    <TableHead>
                        <TableRow>
                            <TableCell>Name</TableCell>
                            <TableCell align="right">Country</TableCell>
                            <TableCell align="right">Phone Number</TableCell>
                            <TableCell align="right">State</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {customers && customers.map((row) => (
                            <TableRow
                                key={row.name}
                                sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                            >
                                <TableCell component="th" scope="row">
                                    {row.name}
                                </TableCell>
                                <TableCell align="right">{row.country}</TableCell>
                                <TableCell align="right">{row.phoneNumber}</TableCell>
                                <TableCell align="right">{row.isPhoneValid}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        </>;
};

export default CustomerList;
