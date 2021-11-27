const SERVER_URL = '';

const ticketsURL = `${SERVER_URL}/tickets/`;

export const getTickets = () => {
    console.log("function");
    return fetch('/tickets').then((response) => {
        console.log(response);
        if(response.status !== 200) {
            throw Error('Unable to fetch Zendesk Tickets');
        }
        return response.json();
    })
}

export const getTicket = (id) => {
    console.log('haha');
    return fetch(`${ticketsURL}${id}`).then((response) =>{
        if(response.status !== 200){
            throw Error('Unable to fetch this Zendesk Tickets')
        }
        return response.json();
    })
}
