/**
 * Source: https://github.com/Redocly/redoc
 *         https://stackoverflow.com/questions/61346751/can-we-replace-swagger-ui-with-redoc-in-springdoc
 *         https://springdoc.org/
 */
import React from 'react';
import {RedocStandalone} from 'redoc';

const Redoc= () => {
    return (
        <RedocStandalone
            specUrl="/v3/api-docs "
            options={{
                nativeScrollbars: true,
                theme: {colors: {primary: {main: '#dd5522'}}},
            }}
        />
    );
};

export default Redoc;